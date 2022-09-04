package ke.kiura.snasa.data.entities

import com.google.gson.annotations.SerializedName

data class LinksEntity(
    @SerializedName("href") var href: String,
    @SerializedName("rel") var rel: String,
    @SerializedName("render") var render: String
)