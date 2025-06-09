package com.ixuea.courses.mymusic.activity

import android.content.Intent

open class BaseCommonActivity: BaseActivity() {
    fun startActivityAfterFinishThis(clazz: Class<*>)
    {
        startActivity(clazz)
    }
    fun startActivity(clazz: Class<*>)
    {
        val intent= Intent(this,clazz)
        startActivity(intent)
    }
}