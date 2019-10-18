package com.gmail.dimakahanovski.appodealtest.paginationrecyeclviewinkotlin

import android.os.Bundle
import android.os.Handler
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import java.util.ArrayList

import com.gmail.dimakahanovski.appodealtest.R
import com.gmail.dimakahanovski.appodealtest.paginationrecyeclviewinkotlin.PaginationListener.Companion.PAGE_START
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    companion object {
        const val URL = "https://api.myjson.com/bins/774q0"
    }

    var mRecyclerView: RecyclerView? = null
    var swipeRefresh: SwipeRefreshLayout? = null
    private var adapter: FilmsAdapter? = null
    private var currentPage = PAGE_START
    private var isLastPage = false
    private val totalPage = 10
    internal var isLoading = false
    internal var itemCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = recyclerView
        swipeRefresh!!.setOnRefreshListener(this)
        mRecyclerView!!.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        mRecyclerView!!.layoutManager = layoutManager
        adapter = FilmsAdapter(ArrayList())
        mRecyclerView!!.adapter = adapter
        doApiCall()


        var paginationListener: PaginationListener;
        paginationListener = object : PaginationListener(layoutManager) {
            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }

            override fun loadMoreItems() {
                Log.e("test", "Loadmore")
                isLoading = true
                currentPage++
                doApiCall()
            }
        }
        mRecyclerView!!.addOnScrollListener(paginationListener)
    }

    fun processJson(json: String): List<Films> {
        val gson: Gson = GsonBuilder().create()
        val films: List<Films> = gson.fromJson(json, Array<Films>::class.java).toList()
        return films
    }

    fun show(films: MutableList<Films>) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = FilmsAdapter(films)
    }

    private fun doApiCall() {
        val items = ArrayList<Films>()
        Handler().postDelayed({
            for (i in 0..9) {

                val response = URL(URL).readText()
                Log.d("Dima", "json? $response")
                val films = processJson(response)
                show(films as MutableList<Films>)
            }

            if (currentPage != PAGE_START) adapter!!.removeLoading()
            adapter!!.addItems(items)
            swipeRefresh!!.isRefreshing = false

            if (currentPage < totalPage) {
                adapter!!.addLoading()
            } else {
                isLastPage = true
            }
            isLoading = false
        }, 1500)
    }

    override fun onRefresh() {
        itemCount = 0
        currentPage = PAGE_START
        isLastPage = false
        adapter!!.clear()
        doApiCall()
    }
}
