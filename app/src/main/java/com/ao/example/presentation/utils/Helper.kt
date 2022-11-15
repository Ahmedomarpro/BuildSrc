package com.ao.example.presentation.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.google.android.material.snackbar.Snackbar


// view
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}


inline fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    snack.show()
}


fun ImageView.loadImage(
    imageUrl: String,
    placeholderDrawable: Drawable? = null,
    progressBar: ProgressBar?
) {
    val theImage = GlideUrl(
        imageUrl, LazyHeaders.Builder()
            .addHeader("User-Agent", "5")
            .build()
    )
    Glide.with(this)
        .load(theImage)
        .error(placeholderDrawable)
        .apply(RequestOptions.timeoutOf(60 * 1000))
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                progressBar?.gone()
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {

                progressBar?.gone()
                return false
            }
        }).into(this)
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}



