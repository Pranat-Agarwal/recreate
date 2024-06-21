package com.example.recreate.network

import kotlinx.serialization.Serializable 
@Serializable
data class marsphoto (
    val id:String,
    @SerialName(value="imag_src")
    val imgsrc:String
)