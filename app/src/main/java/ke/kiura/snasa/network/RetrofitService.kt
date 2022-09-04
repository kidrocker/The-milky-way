package ke.kiura.snasa.network

import ke.kiura.snasa.data.entities.ImageResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("search")
    suspend fun getImages(
        @Query("q") query: String,
        @Query("media_type") mediaType: String,
        @Query("year_start") startYear: String?,
        @Query("year_end") endYear: String?,
        @Query("page") page: Int?
    ): Response<ImageResponseEntity>
}