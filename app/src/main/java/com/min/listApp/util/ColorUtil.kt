package com.min.listApp.util

import android.graphics.Color
import kotlin.random.Random

object ColorUtil {
    fun randomColor() = Color.rgb(Random.nextInt(0, 255), Random.nextInt(0, 255), Random.nextInt(0, 255))
}

