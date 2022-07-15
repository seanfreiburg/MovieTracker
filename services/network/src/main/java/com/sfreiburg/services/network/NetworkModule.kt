package com.sfreiburg.services.network

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {
    companion object {
        private const val API_TOKEN = "d0bfa2d663af7a94e515085e33ab9615"
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGES_BASE_URL = "https://image.tmdb.org/t/p/"

        @Provides
        fun providesRetrofit() =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(ResultCallAdapterFactory())
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor { chain ->
                            val url = chain
                                .request()
                                .url()
                                .newBuilder()
                                .addQueryParameter("api_key", API_TOKEN)
                                .build()
                            chain.proceed(chain.request().newBuilder().url(url).build())
                        }
                        .build()
                )
                .build()

        @Provides
        fun providesDummyService(retrofit: Retrofit): MoviesService =
            retrofit.create(MoviesService::class.java)

        @Provides fun providesMoshi(): Moshi = Moshi.Builder().build()
    }
}
