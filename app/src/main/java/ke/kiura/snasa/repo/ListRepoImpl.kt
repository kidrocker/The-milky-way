package ke.kiura.snasa.repo

import ke.kiura.snasa.data.models.Image
import ke.kiura.snasa.network.BaseApiResponse
import ke.kiura.snasa.network.Resource
import ke.kiura.snasa.network.RetrofitService
import ke.kiura.snasa.util.EntityToImageMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ListRepoImpl @Inject constructor(
    private val retrofitService: RetrofitService,
    private val mapper: EntityToImageMapper
) : BaseApiResponse(), ListRepo {
    override fun searchImage(
        query: String,
        mediaType: String,
        page: Int?,
        start: String?,
        end: String?
    ): Flow<Resource<List<Image>>> {
        return flow {
            emit(Resource.Loading)

            val response = handleApiCall {
                retrofitService.getImages(
                    query = query,
                    mediaType = mediaType,
                    startYear = start,
                    endYear = end,
                    page = page
                )
            }

            when (response) {
                is Resource.Success -> {
                    val data = response.data.collection.images
                    val images = mapper.toModelList(data)
                    emit(Resource.Success(images))
                }
                is Resource.Failure -> emit(Resource.Failure(response.error))
                else -> emit(Resource.Failure("Unknown error occurred"))
            }

        }.flowOn(Dispatchers.IO)
    }
}