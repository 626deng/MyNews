package com.ixuea.courses.mymusic.util

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder

object JsonUtil {

    fun createGson(): Gson
    {
        val gsonBuilder=GsonBuilder()

        //驼峰转下划线
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }




}