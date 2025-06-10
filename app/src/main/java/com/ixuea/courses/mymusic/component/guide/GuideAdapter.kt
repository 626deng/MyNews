package com.ixuea.courses.mymusic.component.guide

import android.content.Context
import android.telephony.TelephonyCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

@Suppress("DEPRECATION")
class GuideAdapter(val context: Context,fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

    var datum=mutableListOf<String>()

    override fun getItem(position: Int): Fragment {
        return GuideFragment.newInstance(datum[position])
    }

    override fun getCount(): Int {
        return datum.size
    }

    fun setDatum1(datum: List<String>)
    {
        this.datum.clear()
        this.datum.addAll(datum)
        notifyDataSetChanged()
    }

}