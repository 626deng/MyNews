package com.ixuea.courses.mymusic.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.FragmentManager
import com.ixuea.courses.mymusic.databinding.FragmentMyDialogBinding
import com.ixuea.superui.date.ScreenUtil

class MyDialogDialogFragment: BaseViewModelDialogFragment<FragmentMyDialogBinding>() {

    lateinit var onClickListener: View.OnClickListener

    override fun initViews() {
        super.initViews()
        isCancelable=false
    }

    override fun initListeners() {
        super.initListeners()
        binding.materialButton.setOnClickListener {
            dismiss()
            onClickListener.onClick(it)
            Log.d("MyDialogFragment",it.toString())
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
    }

    override fun onResume() {
        super.onResume()
        val params: ViewGroup.LayoutParams= dialog!!.window!!.attributes
        params.height= ViewGroup.LayoutParams.WRAP_CONTENT
        params.width= ((ScreenUtil.getScreenWidth(requireContext())*0.9).toInt())
        dialog!!.window!!.attributes=params as WindowManager.LayoutParams
    }

    companion object {
        /**
         * 显示对话框
         */
        fun show(manager: FragmentManager, myOnClickListener: View.OnClickListener) {
            val myDialogFragment= MyDialogDialogFragment()
            myDialogFragment.onClickListener=myOnClickListener
            myDialogFragment.show(manager,"MyDialogFragment")
        }
    }

}