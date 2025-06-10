package com.ixuea.courses.mymusic.component.guide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixuea.courses.mymusic.R
import com.ixuea.courses.mymusic.activity.BaseViewModelActivity
import com.ixuea.courses.mymusic.databinding.FragmentGuideBinding
import com.ixuea.courses.mymusic.fragment.BaseViewModelFragment


class GuideFragment : BaseViewModelFragment<FragmentGuideBinding>() {

    override fun initDatum() {
        super.initDatum()
        val data = requireArguments().getString("id")
        binding.textView.text = data
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDatum()
    }

    companion object {
        fun newInstance(data: String): Fragment {
            val args = Bundle()
            args.putString("id", data)
            val fragment = GuideFragment()
            fragment.arguments = args
            return fragment
        }
    }
}