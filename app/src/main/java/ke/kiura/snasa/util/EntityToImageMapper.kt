package ke.kiura.snasa.util

import ke.kiura.snasa.data.entities.ImageEntity
import ke.kiura.snasa.data.models.Image
import java.text.SimpleDateFormat
import java.util.*

class EntityToImageMapper : EntityMapper<ImageEntity, Image> {
    override fun mapFromEntity(entity: ImageEntity): Image {
        val url = when (entity.links.isNotEmpty()) {
            true -> entity.links[0].href
            false -> ""
        }
        var title = ""
        var center = ""
        var description = ""
        var date = ""

        if (entity.data.isNotEmpty()) {
            title = entity.data[0].title
            center = entity.data[0].center
            description = entity.data[0].description

            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            format.timeZone = TimeZone.getTimeZone("GMT")
            val parsed = format.parse(entity.data[0].dateCreated)

            val localFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            date = parsed?.let { localFormat.format(it) } ?: ""
        }

        return Image(
            url = url,
            title = title,
            center = center,
            description = description,
            date = date
        )
    }

    override fun mapToEntity(domainModel: Image): ImageEntity? {
        return null
    }

    fun toModelList(list: List<ImageEntity>): List<Image> {
        return list.map { mapFromEntity(it) }
    }
}