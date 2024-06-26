package com.example.recreate.kotlin

import com.squareup.moshi.Json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class marsphotos (
    val id : String,
    @Json(name = "imgsrc")
    val imgsrc : String
)