package com.example.recreate.network

import com.squareup.moshi.Json

data class marsphoto (
    val id:String,
    @Json(name="img_src")
    val imgsrc:String
)