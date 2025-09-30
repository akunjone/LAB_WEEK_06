package com.example.lab_week_06

import android.widget.ImageView

public interface ImageLoader {
    public fun loadImage(url: String, target: ImageView)
}