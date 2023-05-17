package com.football_score.utils

import com.football_score.constant.CommonConstants
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("x-rapidapi-host", CommonConstants.X_RAPIDAPI_HOST)
            .addHeader("x-rapidapi-key", CommonConstants.X_RAPIDAPI_KEY)
            .build()

        return chain.proceed(request)
    }
}