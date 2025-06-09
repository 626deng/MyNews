package com.ixuea.courses.mymusic.component.guide

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.ixuea.courses.mymusic.R

class GuideActivity: AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var guideAdapter: GuideAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        viewPager=findViewById(R.id.viewPager)
        viewPager.adapter=guideAdapter
        Log.d(TAG, "onCreate: 1")
    }

    companion object
    {
        const val TAG="GuideActivity"
    }

}