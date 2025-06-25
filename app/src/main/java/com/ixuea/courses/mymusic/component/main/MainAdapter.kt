package com.ixuea.courses.mymusic.component.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ixuea.courses.mymusic.component.discovery.DiscoveryFragment
import com.ixuea.courses.mymusic.component.me.MeFragment
import com.ixuea.courses.mymusic.component.category.CategoryFragment
import com.ixuea.courses.mymusic.component.shortvideo.ShortVideoFragment

class MainAdapter(val count: Int, fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when(position)
        {
            0->  DiscoveryFragment.newInstance()
            1->  ShortVideoFragment.newInstance()
            2->  CategoryFragment.newInstance()
            else ->  MeFragment.newInstance()
        }
    }

    override fun getItemCount(): Int {
        return count
    }

}