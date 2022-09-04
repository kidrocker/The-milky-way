package ke.kiura.snasa.data.entities

import com.google.gson.annotations.SerializedName

data class CollectionEntity(
    @SerializedName("href") var href: String?,
    @SerializedName("items") var images: List<ImageEntity>,
    @SerializedName("version") var version: String?
)