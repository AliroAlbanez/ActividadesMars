package com.example.actividadesmars.models.remote

import com.google.gson.annotations.SerializedName

data class MarsApiClass(
    @SerializedName("price") val price:Int,
    @SerializedName("id") val id:String,
    @SerializedName("type") val type:String,
    @SerializedName("img_src") val imgSrc:String
)
