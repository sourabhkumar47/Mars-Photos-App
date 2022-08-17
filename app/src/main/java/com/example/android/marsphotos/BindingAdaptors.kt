package com.example.android.marsphotos

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.network.MarsPhoto
import com.example.android.marsphotos.overview.PhotoGridAdapter

@BindingAdapter("imageUrl") //tell data binding to execute this binding when viewItem has URL
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

// initialize the PhotoGridAdapter with the list of MarsPhoto objects.
//set the RecyclerView data causes data binding to automatically
// observe the LiveData for the list of MarsPhoto objects
@BindingAdapter("listData")
fun bindRecycleView(
    recyclerView: RecyclerView,
    data: List<MarsPhoto>?
) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}