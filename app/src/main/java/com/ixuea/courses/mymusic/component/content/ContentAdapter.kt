package com.ixuea.courses.mymusic.component.content

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ixuea.courses.mymusic.databinding.ItemContentBinding

class ContentAdapter(): BaseQuickAdapter<Content,ContentAdapter.ViewHolder>(){

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
        data: Content?
    ) {
         holder.bindData(data!!)
    }

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(ItemContentBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    class ViewHolder(val binding: ItemContentBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bindData(data: Content)
        {
            if(data.title!=null) {
                binding.content.text = data.title
            }
            else {
                binding.content.text = data.content
            }

            binding.nickname.text= data.user!!.nickname

            binding.commentCount.text="${data.commentCount}条评论"

            binding.videoContainer.visibility= View.GONE

           if(data.uri!=null)
           {
               binding.videoContainer.visibility= View.VISIBLE
               Glide.with()
           }

        }
    }
}