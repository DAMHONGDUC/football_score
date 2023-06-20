package com.football_score.core.di

import com.football_score.utils.Constants
import com.football_score.data.remote.service.FootballAPIService
import com.football_score.utils.RequestInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetWorkModule {
    @Provides
    fun okHttp(): OkHttpClient {
        val  loggingInteceptor= HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInteceptor)
            .addInterceptor(RequestInterceptor())
            .build();
    }

    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit
    {
        return Retrofit.Builder().
        client(okHttpClient).
        addConverterFactory(GsonConverterFactory.create()).
        baseUrl(Constants.BASE_URL).
        build();
    }

    @Provides
    fun FootballAPIService(retrofit: Retrofit): FootballAPIService
    {
        return retrofit.create(FootballAPIService::class.java)
    }
}