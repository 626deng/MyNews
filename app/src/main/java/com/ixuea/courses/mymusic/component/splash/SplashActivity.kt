package com.ixuea.courses.mymusic.component.splash

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.ixuea.courses.mymusic.activity.BaseViewModelActivity
import com.ixuea.courses.mymusic.component.guide.GuideActivity
import com.ixuea.courses.mymusic.databinding.ActivitySplashBinding
import com.ixuea.courses.mymusic.fragment.MyDialogDialogFragment
import com.ixuea.superui.date.DateUtil
import com.ixuea.superui.util.SuperDarkUtil
import com.permissionx.guolindev.PermissionX
import com.qmuiteam.qmui.util.QMUIStatusBarHelper

class SplashActivity : BaseViewModelActivity<ActivitySplashBinding>() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDatum()
         initViews()
    }

    override fun initDatum() {
        super.initDatum()
        requestPermission()
    }

    private fun requestPermission() {
        PermissionX.init(this)
            .permissions(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE)
            .request { allGranted,grantedList,deniedList->
                if(allGranted)
                {
                    prepareNext()
                }else{
                    //告诉用户为什么需要权限
                    finish()
                }
            }
    }

    private fun prepareNext() {
        Log.d(TAG, "prepareNext: ss")
    }

    private fun showDialogFragment() {
        MyDialogDialogFragment.Companion.show(supportFragmentManager)
        {
            Log.d("SplashActivity","assdadasd")
            val intent= Intent(this, GuideActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun initViews() {
        super.initViews()
        //设置沉浸式状态栏
        QMUIStatusBarHelper.translucent(this)


        if(SuperDarkUtil.isDark(this))
        {
            //设置状态栏文本为白色
            QMUIStatusBarHelper.setStatusBarDarkMode(this)
        }
        else{
            //设置状态栏文本为黑色
            QMUIStatusBarHelper.setStatusBarLightMode(this)
        }


        binding.textView.text= "时间：${DateUtil.getDate()}"

        showDialogFragment()
    }

    companion object{
        const val TAG="SplashActivity"
    }

}