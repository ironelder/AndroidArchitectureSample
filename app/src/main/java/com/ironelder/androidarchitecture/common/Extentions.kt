package com.ironelder.androidarchitecture.common

import android.content.Context
import android.widget.Toast

fun Context.showToastMessage(messageResId:Int, duration:Int = Toast.LENGTH_LONG) = Toast.makeText(this, messageResId, duration).show()
fun Context.showToastMessage(messageResId:String, duration:Int = Toast.LENGTH_LONG) = Toast.makeText(this, messageResId, duration).show()