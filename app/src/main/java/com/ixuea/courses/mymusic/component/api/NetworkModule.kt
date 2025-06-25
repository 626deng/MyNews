package com.ixuea.courses.mymusic.component.api

import androidx.core.util.TimeUtils
import com.ixuea.courses.mymusic.util.JsonUtil
import com.ixuea.courses.mymusic.util.NetworkUtil
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {


    /**
     * 创建okhttpClient对象
     */
    fun provideOkhttpClient(): OkHttpClient
    {
        val builder= OkHttpClient.Builder()

//        val cache= Cache()
//
//        builder.cache(cache)

        builder.connectTimeout(10, TimeUnit.SECONDS)
        builder.writeTimeout(10, TimeUnit.SECONDS)
        builder.readTimeout(10, TimeUnit.SECONDS)

        val loggingInterceptor= HttpLoggingInterceptor()
        loggingInterceptor.level= HttpLoggingInterceptor.Level.BASIC
        builder.addInterceptor(loggingInterceptor)

        return builder.build()
    }

    /**
     * 创建retrofit对象
     */
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit
    {
        val retrofit= Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(NetworkUtil.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create(JsonUtil.createGson()))
            .build()
        return retrofit
    }
}