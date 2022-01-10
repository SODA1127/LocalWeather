package com.soda1127.example.localweather.extensions

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

fun ImageView.clear() = Glide.with(context).clear(this)

fun ImageView.loadSvg(url: String) {
    GlideToVectorYou.init().with(context)
        .load(Uri.parse(url), this)

}
