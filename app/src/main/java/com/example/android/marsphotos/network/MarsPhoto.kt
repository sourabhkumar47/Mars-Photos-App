package com.example.android.marsphotos.network

import com.squareup.moshi.Json

//Moshi parse the JSON object into Kotlin object
//moshi need to have kotlin data class to store parse result 👇

data class MarsPhoto(
    val id : String,
    //as both json and kotlin format are not same so we are using @json
    @Json(name = "img_src") val imgSrcUrl : String
)