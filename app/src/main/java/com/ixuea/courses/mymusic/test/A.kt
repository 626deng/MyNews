package com.ixuea.courses.mymusic.test

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class A: AppCompatActivity(){
    lateinit var myTest:myTest
    val a:String get()=null.toString()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        myTest.onSuccess()
        a
    }

    fun getMyTes(myTest: myTest)
    {
        this.myTest=myTest
    }

}