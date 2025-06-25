package com.ixuea.courses.mymusic.entity.response

import com.ixuea.courses.mymusic.component.content.Content

class Meta<T> {
    /**
     * 有多少条
     */
    var total:Int?=null

    /**
     * 有多少页
     */
    var pages: Int?=null

    /**
     * 当前每页显示多少条
     */
    var size: Int?=null

    /**
     * 当前页
     */
    var page: Int?=null

    /**
     * 下一页
     */
    var next: Int?=null

    var data: List<T>?=null
}