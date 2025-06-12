package com.ixuea.courses.mymusic.component.guide

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.ixuea.courses.mymusic.MainActivity
import com.ixuea.courses.mymusic.activity.BaseViewModelActivity
import com.ixuea.courses.mymusic.databinding.ActivityGuideBinding
import com.ixuea.courses.mymusic.util.Constant
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class GuideActivity: BaseViewModelActivity<ActivityGuideBinding>() {

    lateinit var guideAdapter: GuideAdapter
    var list=listOf("第一章","第二章","第三章","第四章")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDatum()
        initListeners()
    }

    override fun initDatum() {
        super.initDatum()
        guideAdapter= GuideAdapter(this,supportFragmentManager)
        binding.viewPager.adapter=guideAdapter
        binding.circleIndicator.setViewPager(binding.viewPager)
        guideAdapter.registerDataSetObserver(binding.circleIndicator.dataSetObserver)
        guideAdapter.setDatum1(list)
        Log.d(TAG, "onCreate: 1")
    }

    override fun initListeners() {
        super.initListeners()
        binding.buttonLoginOrRegister.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            intent.setAction(Constant.ACTION_LOGIN)
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun testGet() {
        val okHttpClient= OkHttpClient()
        val request= Request.Builder().build()
        val call=okHttpClient.newCall(request)
        call.enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.d("GuideActivity","onFailure")
            }

            override fun onResponse(call: Call, response: Response) {
                val datum= response.body?.string()
                Log.d(TAG, "onResponse: ${datum.toString()}")
            }

        })
    }

    companion object
    {
        const val TAG="GuideActivity"
    }

}
