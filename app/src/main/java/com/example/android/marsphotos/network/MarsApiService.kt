package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.http.GET
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * The Retrofit object with the Moshi converter.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//initialize the retrofit service
//this is the public singleton object that can be accessed from rest of app

/**
"lazy instantiation" is when object creation is purposely delayed until
 you actually need that object to avoid unnecessary computation or use of
other computing resources.

 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object MarsApi {
    val retrofitService: MarsApiService by lazy {
        //initialize retrofit service
        retrofit.create(MarsApiService::class.java)
    }

}

//how Retrofit talks to the web server using HTTP requests
/**
 * A public interface that exposes the [getPhotos] method
 */
interface MarsApiService {
    /**
     * Returns a [List] of [MarsPhoto] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "photos" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
