package ke.kiura.snasa.ui.common

import android.graphics.drawable.Drawable
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import ke.kiura.snasa.R

@BindingAdapter("load", "error")
fun loadImage(view: ImageView, url: String?, error: Drawable) {
    Glide.with(view).load(url)
        .error(error)
        .placeholder(R.drawable.ic_broken_image)
        .into(view)
}

@BindingAdapter("html")
fun toHtml(view: TextView, text: String) {
    view.text = Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
}