package com.jye.devkit.base.util

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import com.jye.devkit.base.DkBase
import java.io.ByteArrayOutputStream

/**
 * Bitmap转字节数组
 *
 * @param format 图片格式
 * @return 字节数组
 * @author jye
 * @since 1.0
 */
fun Bitmap.toByteArray(format: Bitmap.CompressFormat): ByteArray {
    val baos = ByteArrayOutputStream()
    this.compress(format, 100, baos)
    return baos.toByteArray()
}

/**
 * Bitmap转Drawable
 *
 * @return Drawable
 * @author jye
 * @since 1.0
 */
fun Bitmap.toDrawable(): Drawable {
    return BitmapDrawable(DkBase.getResources(), this)
}

/**
 * 图片转换成base64字符串
 *
 * @return base64字符串
 * @author jye
 * @since 1.0
 */
fun Bitmap.toBase64String(): String {
    return BitmapUtils.bitmapToBase64String(this)
}
