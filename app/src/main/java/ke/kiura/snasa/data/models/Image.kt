package ke.kiura.snasa.data.models

import java.io.Serializable

data class Image(
    val url: String,
    val title: String,
    val center: String,
    val description: String,
    val date: String
):Serializable
