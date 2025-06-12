package com.ixuea.courses.mymusic.component.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ixuea.courses.mymusic.component.discovery.DiscoveryFragment
import com.ixuea.courses.mymusic.component.me.MyFragment
import com.ixuea.courses.mymusic.component.sort.SortFragment
import com.ixuea.courses.mymusic.component.video.VideoFragment

class BottomAdapter(val count: Int, fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when(position)
        {
            0->  DiscoveryFragment.newInstance()
            1->  VideoFragment.newInstance()
            2->  SortFragment.newInstance()
            else ->  MyFragment.newInstance()
        }

    }

    override fun getItemCount(): Int {
        return count
    }
}