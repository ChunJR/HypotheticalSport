package com.chun.hypotheticalsport.di

import com.chun.hypotheticalsport.data.remote.SportApi
import com.chun.hypotheticalsport.data.repository.RemoteDataSourceImpl
import com.chun.hypotheticalsport.domain.repository.RemoteDataSource
import com.chun.hypotheticalsport.util.Constants
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideSportApi(retrofit: Retrofit): SportApi {
        return retrofit.create(SportApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        sportApi: SportApi,
    ): RemoteDataSource {
        return RemoteDataSourceImpl(sportApi)
    }
}
