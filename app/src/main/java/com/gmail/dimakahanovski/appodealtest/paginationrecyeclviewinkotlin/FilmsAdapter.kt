package com.gmail.dimakahanovski.appodealtest.paginationrecyeclviewinkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import butterknife.ButterKnife
import by.itacademy.pvt.utils.loadImage
import com.gmail.dimakahanovski.appodealtest.R
import kotlinx.android.synthetic.main.item_post.view.*

class FilmsAdapter(private val filmsItems: MutableList<Films>?) :
    RecyclerView.Adapter<BaseViewHolder>() {
    private var isLoaderVisible = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        when (viewType) {
            VIEW_TYPE_NORMAL -> return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
            )
            VIEW_TYPE_LOADING -> return ProgressHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_loading, parent, false)
            )
            else -> return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemViewType(position: Int): Int {
        return if (isLoaderVisible) {
            if (position == filmsItems!!.size - 1) VIEW_TYPE_LOADING else VIEW_TYPE_NORMAL
        } else {
            VIEW_TYPE_NORMAL
        }
    }

    override fun getItemCount(): Int {
        return filmsItems?.size ?: 0
    }

    fun addItems(filmItems: List<Films>) {
        filmsItems!!.addAll(filmItems)
        notifyDataSetChanged()
    }

    fun addLoading() {
        isLoaderVisible = true
        filmsItems!!.add(Films())
        notifyItemInserted(filmsItems.size - 1)
    }

    fun removeLoading() {
        isLoaderVisible = false
        val position = filmsItems!!.size - 1
        val item = getItem(position)
        if (item != null) {
            filmsItems.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun clear() {
        filmsItems!!.clear()
        notifyDataSetChanged()
    }

    private fun getItem(position: Int): Films? {
        return filmsItems!![position]
    }

    class ViewHolder(view: View) : BaseViewHolder(view) {


        private val image = view.imageMovie
        private val name = view.name
        private val description = view.description
        private val countries = view.countries
        private val actors = view.actors
        private val duration = view.duration
        private val genres = view.genres
        private val year = view.year
        private val age = view.age
        private val added = view.added
        private val created = view.created

        fun bind(item: Films) {
            item.image?.let { loadImage(it, image) }
            name.text = item.name
            description.text = item.description
            countries.text = item.countries
            actors.text = item.actors
            duration.text = item.duration.toString()
            genres.text = item.genres
            year.text = item.year.toString()
            age.text = item.age.toString()
            added.text = item.added
            created.text = item.created
        }

        override fun clear() {
        }
    }

    inner class ProgressHolder internal constructor(itemView: View) : BaseViewHolder(itemView) {
        init {
            ButterKnife.bind(this, itemView)
        }

        override fun clear() {}
    }

    companion object {
        private val VIEW_TYPE_LOADING = 0
        private val VIEW_TYPE_NORMAL = 1
    }
}
