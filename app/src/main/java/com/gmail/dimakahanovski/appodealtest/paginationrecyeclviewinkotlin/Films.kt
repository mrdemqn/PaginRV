package com.gmail.dimakahanovski.appodealtest.paginationrecyeclviewinkotlin

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Films (

    @SerializedName("countries")
    @Expose
    var countries: String? = null,

    @SerializedName("duration")
    @Expose
    var duration: Int? = null,

    @SerializedName("partner")
    @Expose
    var partner: String? = null,

    @SerializedName("actors")
    @Expose
    var actors: String? = null,

    @SerializedName("image")
    @Expose
    var image: String? = null,

    @SerializedName("content_group_ptr")
    @Expose
    var contentGroupPtr: Int? = null,

    @SerializedName("favorites")
    @Expose
    var favorites: Int? = null,

    @SerializedName("adult")
    @Expose
    var adult: Int? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("genres")
    @Expose
    var genres: String? = null,

    @SerializedName("year")
    @Expose
    var year: Int? = null,

    @SerializedName("content_type_ptr")
    @Expose
    var contentTypePtr: Int? = null,

    @SerializedName("partner_path")
    @Expose
    var partnerPath: String? = null,

    @SerializedName("added")
    @Expose
    var added: String? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("locked")
    @Expose
    var locked: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("comments")
    @Expose
    var comments: String? = null,

    @SerializedName("director")
    @Expose
    var director: Any? = null,

    @SerializedName("created")
    @Expose
    var created: String? = null,

    @SerializedName("age")
    @Expose
    var age: String? = null,

    @SerializedName("status")
    @Expose
    var status: Int? = null

)
//var countries: String? = null
//var duration: Int? = null
//var partner: String? = null
//var actors: String? = null
//var image: String? = null
//var contentGroupPtr: Int? = null
//var favorites: Int? = null
//var adult: Int? = null
//var description: String? = null
//var genres: String? = null
//var year: Int? = null
//var contentTypePtr: Int? = null
//var partnerPath: String? = null
//var added: String? = null
//var id: Int? = null
//var locked: Int? = null
//var name: String? = null
//var comments: String? = null
//var director: Any? = null
//var created: String? = null
//var age: String? = null
//var status: Int? = null