package ke.kiura.snasa.data.entities

import com.google.gson.annotations.SerializedName

data class ImageDataEntity(
    @SerializedName("center") var center: String,
    @SerializedName("date_created") var dateCreated: String,
    @SerializedName("description") var description: String,
    @SerializedName("keywords") var keywords: List<String>,
    @SerializedName("media_type") var mediaType: String,
    @SerializedName("nasa_id") var nasaId: String,
    @SerializedName("title") var title: String
)