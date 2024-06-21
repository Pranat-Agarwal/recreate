package com.example.recreate.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL="https//:android-kotlin-fun-mars-server.appspot.com"

private val retrofit=Retrofit.Builder()
    .addConverterFactory(ScalarsConvertersFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface marsapiservice{
    @GET("photos")

    suspend fun getPhotos():String
}

object marsapi{
    val retrofitservice : marsapiservice by lazy{
        retrofit.create(marsapiservice::class.java)
    }
}
fun main(){

}