package ke.kiura.snasa.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ke.kiura.snasa.SnasaApp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApp(@ApplicationContext app:Context):SnasaApp{
        return app as SnasaApp
    }

    @Singleton
    @Provides
    fun provideContext(app: SnasaApp):Context{
        return app.applicationContext
    }
}