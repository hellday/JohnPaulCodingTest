package com.johnpaul.codingtest.utils

import android.content.res.Resources

object SizeUtil{
    val screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels
    val width = (screenWidth) / 2
    val totalHeight = (screenWidth - 15*2) * 2
    val shortHeight = (totalHeight - 15) / 3
    val tallHeight = shortHeight * 2
}