package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//initialize the retrofit service
//this is the public singleton object that can be accessed from rest of app

/**
"lazy instantiation" is when object creation is purposely delayed until
 you actually need that object to avoid unnecessary computation or use of
other computing resources.
*/

object MarsApi {
    val retrofitService: MarsApiService by lazy {
        //initialize retrofit service
        retrofit.create(MarsApiService::class.java)
    }

}

//how Retrofit talks to the web server using HTTP requests
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): String
}

//class MarsApiService {
//
//}