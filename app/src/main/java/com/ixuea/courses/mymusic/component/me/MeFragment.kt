package com.ixuea.courses.mymusic.component.me

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixuea.courses.mymusic.R
import com.ixuea.courses.mymusic.databinding.FragmentMeBinding
import com.ixuea.courses.mymusic.fragment.BaseViewModelFragment


class MeFragment : BaseViewModelFragment<FragmentMeBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance(): MeFragment {
            val args= Bundle()
            val fragment= MeFragment()
            fragment.arguments=args
            return fragment
        }
    }

}