package com.ixuea.courses.mymusic.fragment

import androidx.fragment.app.DialogFragment

open class BaseDialogFragment: DialogFragment() {
    protected open fun initDatum(){}
    protected open fun initViews(){}
    protected open fun initListeners(){}
}