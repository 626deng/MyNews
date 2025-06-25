package com.ixuea.courses.mymusic.component.discovery

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ixuea.courses.mymusic.component.category.Category
import com.ixuea.courses.mymusic.component.content.ContentFragment

class DiscoveryAdapter(fragmentActivity: FragmentActivity, val datum: List<Category>):
    FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
       return ContentFragment.newInstance(datum[position].id)
    }

    override fun getItemCount(): Int {
        return datum.size

    }
}