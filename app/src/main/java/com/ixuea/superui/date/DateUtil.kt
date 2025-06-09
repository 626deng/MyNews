package com.ixuea.superui.date

import android.icu.util.Calendar

object DateUtil {
    fun getDate()= Calendar.getInstance().get(Calendar.YEAR)
}