package com.ixuea.superui.util

import android.content.Context
import android.content.res.Configuration

object SuperDarkUtil {

    /**
     * 判断是否是深色模型
     */
    fun isDark(context: Context): Boolean {
        val nightModeFlags: Int =
            context.getResources().getConfiguration().uiMode and Configuration.UI_MODE_NIGHT_MASK
        val isDarkMode = nightModeFlags == Configuration.UI_MODE_NIGHT_YES
        return isDarkMode
    }
}