package com.jye.devkit.base.util

import android.text.TextUtils
import android.widget.Toast
import com.jye.devkit.base.DkBase

/**
 * 显示Toast
 *
 * @param message 显示内容
 * @author jye
 * @since 1.0
 */
fun showToast(message: CharSequence?) {
    showToast(message, Toast.LENGTH_SHORT)
}

/**
 * 显示Toast
 *
 * @param message 显示内容
 * @param duration 显示时长（单位：毫秒）
 * @author jye
 * @since 1.0
 */
fun showToast(message: CharSequence?, duration: Int) {
    if (TextUtils.isEmpty(message)) return

    DkBase.runOnUiThread(Runnable {
        val context = DkBase.getAppContext()
        ToastUtils.show(context, message, duration)
    })
}

/**
 * 显示Toast
 *
 * @param message 显示内容
 * @param duration 显示时长（单位：毫秒）
 * @param gravity 显示位置
 * @author jye
 * @since 1.0
 */
fun showToast(message: CharSequence?, duration: Int, gravity: Int) {
    showToast(message, duration, gravity, 0, 0)
}

/**
 * 显示Toast
 *
 * @param message 显示内容
 * @param duration 显示时长（单位：毫秒）
 * @param gravity 显示位置
 * @param xOffset x轴偏移量
 * @param yOffset y轴偏移量
 * @author jye
 * @since 1.0
 */
fun showToast(message: CharSequence?, duration: Int, gravity: Int, xOffset: Int, yOffset: Int) {
    if (TextUtils.isEmpty(message)) return

    DkBase.runOnUiThread(Runnable {
        val context = DkBase.getAppContext()
        ToastUtils.customToastGravity(
            context, message, duration, gravity, xOffset, yOffset
        )
    })
}