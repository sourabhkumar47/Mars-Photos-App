package com.example.android.marsphotos

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter //tell data binding to execute this binding when viewItem has URL
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        //convert the URL string to a Uri
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        //from coil - image viewer
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}