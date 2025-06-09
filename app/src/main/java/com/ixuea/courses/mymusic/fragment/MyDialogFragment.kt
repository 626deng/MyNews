package com.ixuea.courses.mymusic.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.google.android.material.button.MaterialButton
import com.ixuea.courses.mymusic.R
import com.ixuea.superui.date.ScreenUtil

class MyDialogFragment: BaseDialogFragment() {

    lateinit var materialButton: Button
    lateinit var onClickListener: View.OnClickListener

    override fun initViews() {
        super.initViews()
        isCancelable=false
    }

    override fun initListeners() {
        super.initListeners()
        materialButton.setOnClickListener {
            dismiss()
            onClickListener.onClick(it)
            Log.d("MyDialogFragment",it.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_my_dialog,container,false)
        materialButton=view.findViewById(R.id.materialButton)
        return view
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
            val myDialogFragment= MyDialogFragment()
            myDialogFragment.onClickListener=myOnClickListener
            myDialogFragment.show(manager,"MyDialogFragment")
        }
    }

}