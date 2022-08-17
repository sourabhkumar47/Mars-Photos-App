package com.example.android.marsphotos.overview

import android.widget.ListAdapter
import com.example.android.marsphotos.network.MarsPhoto

class PhotoGridAdaptor : ListAdapter<MarsPhoto,
        PhotoGridAdaptor.MarsPhotoViewHolder>(DiffCallback) {
}