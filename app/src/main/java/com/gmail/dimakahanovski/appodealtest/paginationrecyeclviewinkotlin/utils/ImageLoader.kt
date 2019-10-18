package by.itacademy.pvt.utils

import android.net.Uri
import android.widget.ImageView
import com.gmail.dimakahanovski.appodealtest.R
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

fun loadCircleImage(url: String, imageView: ImageView) {
    Picasso.get()
        .load(Uri.parse(url))
        .error(R.drawable.error_image)
        .transform(CropCircleTransformation())
        .into(imageView)
}

fun loadImage(url: String, imageView: ImageView) {
    Picasso.get()
        .load(Uri.parse(url))
        .error(R.drawable.error_image)
        .into(imageView)
}