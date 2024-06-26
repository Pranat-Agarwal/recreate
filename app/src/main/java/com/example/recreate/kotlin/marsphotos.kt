package com.example.recreate.kotlin

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class marsphotos (
    val id : String,
    @SerialName(value = "imgsrc")
    val imgsrc : String
)