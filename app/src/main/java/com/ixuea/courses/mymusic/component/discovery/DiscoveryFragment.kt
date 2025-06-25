package com.ixuea.courses.mymusic.component.discovery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ixuea.courses.mymusic.databinding.FragmentDiscoveryBinding
import com.ixuea.courses.mymusic.fragment.BaseViewModelFragment
import com.ixuea.courses.mymusic.util.Constant
import com.ixuea.courses.mymusic.util.DataUtil

class DiscoveryFragment : BaseViewModelFragment<FragmentDiscoveryBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDatum()
    }


    companion object {
        @JvmStatic
        fun newInstance(): DiscoveryFragment
        {
            val args= Bundle()
            val fragment= DiscoveryFragment()
            fragment.arguments=args
            return fragment
        }
    }



    override fun initDatum() {
        super.initDatum()
        val adapter= DiscoveryAdapter(requireActivity(), DataUtil.categories)
        binding.pager.adapter=adapter
        TabLayoutMediator(binding.tabLayout,binding.pager,object : TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(
                tab: TabLayout.Tab,
                position: Int
            ) {
                tab.text= DataUtil.categories[position].title
            }
        }).attach()
    }

}