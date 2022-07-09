package com.mobileweb3.dvs.android.utils

import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

fun <T : Drawable> RequestBuilder<T>.applyDefaults(): RequestBuilder<T> {
    return apply(
        RequestOptions()
            .centerInside()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
    ).transition(DrawableTransitionOptions.withCrossFade())
}