package com.ixuea.courses.mymusic.component.main

import android.content.Intent
import android.os.Bundle
import com.angcyo.tablayout.delegate2.ViewPager2Delegate
import com.ixuea.courses.mymusic.R
import com.ixuea.courses.mymusic.activity.BaseViewModelActivity
import com.ixuea.courses.mymusic.component.login.LoginHomeActivity
import com.ixuea.courses.mymusic.databinding.ActivityMainBinding
import com.ixuea.courses.mymusic.databinding.TabItemBinding
import com.ixuea.courses.mymusic.util.Constant

class MainActivity : BaseViewModelActivity<ActivityMainBinding>(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val action=intent.action
        if(action== Constant.ACTION_LOGIN)
        {
            val intent= Intent(this, LoginHomeActivity::class.java)
            startActivity(intent)
        }

        for(i in indicatorList.indices)
        {
            TabItemBinding.inflate(layoutInflater).apply {
                content.text=indicatorList[i]
                icon.setImageResource(iconList[i])
                binding.dslTabLayout.addView(root)
            }
        }

        binding.viewPager2.adapter= MainAdapter(4, this)
        binding.viewPager2.offscreenPageLimit=4

        ViewPager2Delegate.Companion.install(binding.viewPager2,binding.dslTabLayout,true)
    }

    companion object{
        val indicatorList = listOf("发现", "视频", "分类", "我的")
        val iconList=listOf(
            R.drawable.selector_tab_discovery,
            R.drawable.selector_tab_video,
            R.drawable.selector_tab_sort,
            R.drawable.selector_tab_me)
    }

}