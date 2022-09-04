package ke.kiura.snasa.repo

import ke.kiura.snasa.data.models.Image
import ke.kiura.snasa.network.Resource
import kotlinx.coroutines.flow.Flow

interface ListRepo {
    fun searchImage(query: String, mediaType:String,page:Int?, start:String?, end:String?): Flow<Resource<List<Image>>>
}