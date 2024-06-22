package com.example.recreate.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL="https//:android-kotlin-fun-mars-server.appspot.com"

private val moshi=Moshi.Builder()
    .add(kotlinJsonAdapterFactory())
    .build()
private val retrofit=Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface marsapiservice{
    @GET("photos")

    suspend fun getPhotos():List<marsphoto>
}

object marsapi{
    val retrofitservice : marsapiservice by lazy{
        retrofit.create(marsapiservice::class.java)
    }
}