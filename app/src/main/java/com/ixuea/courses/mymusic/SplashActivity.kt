package com.ixuea.courses.mymusic

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.nfc.Tag
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.ixuea.courses.mymusic.activity.BaseLoginActivity
import com.ixuea.courses.mymusic.component.guide.GuideActivity
import com.ixuea.courses.mymusic.fragment.MyDialogFragment
import com.ixuea.superui.date.DateUtil
import com.permissionx.guolindev.PermissionX
import com.qmuiteam.qmui.util.QMUIStatusBarHelper

class SplashActivity : BaseLoginActivity(){

    lateinit var textView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initDatum()
        initViews()
    }

    override fun initDatum() {
        super.initDatum()
        textView=findViewById(R.id.textView)
        requestPermission()
    }

    private fun requestPermission() {
        PermissionX.init(this)
            .permissions(Manifest.permission.CAMERA,
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
        MyDialogFragment.show(supportFragmentManager)
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

        //设置状态栏文本为黑色
        QMUIStatusBarHelper.setStatusBarLightMode(this)

        textView.text= "时间：${DateUtil.getDate()}"

        showDialogFragment()
    }

    companion object{
        const val TAG="SplashActivity"
    }

}