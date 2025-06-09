package com.ixuea.superui.date

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager


object ScreenUtil {
    fun getScreenWidth(context: Context): Int
    {
        val wm=context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        wm.defaultDisplay.getMetrics(dm)
        val screenWidth = dm.widthPixels
        return screenWidth
    }
}