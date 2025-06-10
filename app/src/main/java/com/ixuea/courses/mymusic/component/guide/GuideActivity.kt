package com.ixuea.courses.mymusic.component.guide

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.ixuea.courses.mymusic.R
import com.ixuea.courses.mymusic.activity.BaseActivity
import com.ixuea.courses.mymusic.activity.BaseViewModelActivity
import com.ixuea.courses.mymusic.databinding.ActivityGuideBinding

class GuideActivity: BaseViewModelActivity<ActivityGuideBinding>() {

    lateinit var guideAdapter: GuideAdapter
    var list=listOf("第一章","第二章","第三章","第四章")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        guideAdapter= GuideAdapter(this,supportFragmentManager)
        binding.viewPager.adapter=guideAdapter
        guideAdapter.setDatum1(list)
        Log.d(TAG, "onCreate: 1")
    }

    companion object
    {
        const val TAG="GuideActivity"
    }

}