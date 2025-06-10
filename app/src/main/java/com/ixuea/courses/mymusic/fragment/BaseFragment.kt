package com.ixuea.courses.mymusic.fragment

import androidx.fragment.app.Fragment

open class BaseFragment: Fragment() {
    protected open fun initDatum(){}
    protected open fun initViews(){}
    protected open fun initListeners(){}
}