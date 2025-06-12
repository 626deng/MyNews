package com.ixuea.courses.mymusic.component.sort

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixuea.courses.mymusic.R
import com.ixuea.courses.mymusic.component.me.MyFragment

class SortFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sort, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(): SortFragment {
            val args= Bundle()
            val fragment= SortFragment()
            fragment.arguments=args
            return fragment
        }

    }

}