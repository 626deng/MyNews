package com.ixuea.courses.mymusic.component.shortvideo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixuea.courses.mymusic.R


class ShortVideoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_short_video, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(): ShortVideoFragment {
            val args= Bundle()
            val fragment= ShortVideoFragment()
            fragment.arguments=args
            return fragment
        }
    }
}