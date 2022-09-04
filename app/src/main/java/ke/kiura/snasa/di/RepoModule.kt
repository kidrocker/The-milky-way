package ke.kiura.snasa.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ke.kiura.snasa.network.RetrofitService
import ke.kiura.snasa.repo.ListRepo
import ke.kiura.snasa.repo.ListRepoImpl
import ke.kiura.snasa.util.EntityToImageMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Singleton
    @Provides
    fun provideImageMapper(): EntityToImageMapper {
        return EntityToImageMapper()
    }

    @Provides
    @Singleton
    fun provideListRepo(
        retrofitService: RetrofitService,
        entityToImageMapper: EntityToImageMapper
    ): ListRepo {
        return ListRepoImpl(
            retrofitService,
            entityToImageMapper
        )
    }
}