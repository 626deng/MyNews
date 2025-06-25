package com.ixuea.courses.mymusic.repository

import androidx.annotation.Size
import com.ixuea.courses.mymusic.component.api.DefaultNetworkService
import com.ixuea.courses.mymusic.component.content.Content
import com.ixuea.courses.mymusic.entity.response.ListResponse
import okhttp3.Call

/**
 * 网络数据仓库
 */
object DefaultNetworkRepository {

    private val service: DefaultNetworkService by lazy {
        DefaultNetworkService.create()
    }

    suspend fun contents(
        last: String? = null,
        userId: String? = null,
        size: Int? = null,
        style: Int? = null
    ) : ListResponse<Content>{
         return service.contents(last,userId,size,style)
    }

}