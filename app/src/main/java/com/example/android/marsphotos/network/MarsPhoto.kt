package com.example.android.marsphotos.network

import com.squareup.moshi.Json

/**
 * This data class defines a Mars photo which includes an ID, and the image URL.
 * The property names of this data class are used by Moshi to match the names of
 * values in JSON.
 */

data class MarsPhoto(
    val id : String,
    //as both json and kotlin format are not same so we are using @json
    @Json(name = "img_src") val imgSrcUrl : String
)