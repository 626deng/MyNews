package com.ixuea.courses.mymusic.entity.response

open class BaseResponse {

    var status=0

    var message: String?=null

    val isSucceed: Boolean
        get() = status == 0
}