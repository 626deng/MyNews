package com.ixuea.courses.mymusic.component.api

import com.ixuea.courses.mymusic.component.content.Content
import com.ixuea.courses.mymusic.entity.response.DetailResponse
import com.ixuea.courses.mymusic.entity.response.ListResponse
import retrofit2.create
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query

interface DefaultNetworkService {

    @GET("v1/contents")
    suspend fun contents(
        @Query(value = "last") last: String?=null,
        @Query(value = "user_id") userId: String?=null,
        @Query(value = "size")size: Int?=10,
        @Query(value = "style")style: Int?=null
    ): ListResponse<Content>

    @GET("v1/contents/{id}")
    suspend fun contentDetail(
        @Path("id")
       id: String
    ): DetailResponse<Content>
    
    companion object{
        fun create(): DefaultNetworkService
        {
            return NetworkModule.provideRetrofit(NetworkModule.provideOkhttpClient())
                .create(DefaultNetworkService::class.java)
        }
    }


}