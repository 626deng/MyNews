package com.ixuea.courses.mymusic.component.me

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixuea.courses.mymusic.R
import com.ixuea.courses.mymusic.component.discovery.DiscoveryFragment


class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(): MyFragment {
            val args= Bundle()
            val fragment= MyFragment()
            fragment.arguments=args
            return fragment
        }

    }
}