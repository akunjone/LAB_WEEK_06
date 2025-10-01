package com.example.lab_week_06

import android.widget.ImageView
import com.bumptech.glide.Glide
import android.content.Context
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.lab_week_06.ImageLoader

class GlideImageLoader(private val context: Context) : ImageLoader {
    override fun loadImage(imageUrl: String, imageView: ImageView) {
        Glide.with(context)
            .load(imageUrl)
            //.centerCrop()
            .apply(RequestOptions().transform(RoundedCorners(20)))
            .into(imageView)
    }
}