package com.ada.pokedex_android.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.ada.mb_kt_006_projeto_final.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName

data class Pokemon(

    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
) {
    companion object {

        @JvmStatic
        @BindingAdapter("android:src")
        fun loadImage(view: ImageView, imageUrl: String) {
            Glide.with(view.context)
                .load(imageUrl)
                .apply(RequestOptions().error(R.drawable.no_image))
                .into(view)
        }
    }
}