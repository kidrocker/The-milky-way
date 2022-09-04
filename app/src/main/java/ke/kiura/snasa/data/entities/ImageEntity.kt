package ke.kiura.snasa.data.entities

import com.google.gson.annotations.SerializedName

data class ImageEntity(
    @SerializedName("href") var href: String,
    @SerializedName("data") var data: List<ImageDataEntity>,
    @SerializedName("links") var links: List<LinksEntity>
)
