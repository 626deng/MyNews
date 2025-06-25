package com.ixuea.courses.mymusic.component.content

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.ixuea.courses.mymusic.R
import com.ixuea.courses.mymusic.component.category.Category
import com.ixuea.courses.mymusic.databinding.FragmentContentBinding
import com.ixuea.courses.mymusic.fragment.BaseViewModelFragment
import com.ixuea.courses.mymusic.util.Constant
import kotlinx.coroutines.launch

/**
 * 内容界面
 */
class ContentFragment : BaseViewModelFragment<FragmentContentBinding>(){

    private lateinit var viewModel: ContentViewModel
    private lateinit var adapter: ContentAdapter

    override fun initViews() {
        super.initViews()
        binding.list.apply {
            layoutManager= LinearLayoutManager(activity)
        }
    }

    override fun initDatum() {
        super.initDatum()
        viewModel= ViewModelProvider(this).get(ContentViewModel::class.java)
        adapter= ContentAdapter()
        binding.list.adapter=adapter
        lifecycleScope.launch {
            viewModel.data.collect {
                Log.d(TAG, "initDatum: ${it.data!![0].title}")
                adapter.submitList(it.data)
            }
        }
        viewModel.loadMore()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initDatum()
    }

    companion object{
        const val TAG="ContentFragment"
        fun newInstance(categoryId: String?=null): ContentFragment{
            val args = Bundle()
            categoryId?.let {
                args.putString(Constant.ID,it)
            }
            val fragment = ContentFragment()
            fragment.arguments = args
            return fragment
        }
    }

}