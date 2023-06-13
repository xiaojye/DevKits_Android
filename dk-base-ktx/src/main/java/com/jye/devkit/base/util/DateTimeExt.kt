package com.jye.devkit.base.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * 转换为yyyy-MM-dd HH:mm:ss格式（分隔符可替换）
 *
 * @param separator1 年月日分隔符
 * @param separator2 时分秒分隔符
 * @return yyyy-MM-dd HH:mm:ss
 * @author jye
 * @since 1.0
 */
fun Long.toYYYYMMDDHHMMSS(separator1: CharSequence = "-", separator2: CharSequence = ":"): String {
    val dateFormat = SimpleDateFormat(
        "yyyy${separator1}MM${separator1}dd HH${separator2}mm${separator2}ss",
        Locale.CHINA
    )
    return dateFormat.format(this)
}

/**
 * 转换为yyyy-MM-dd HH:mm:ss格式（分隔符可替换）
 *
 * @param separator1 年月日分隔符
 * @param separator2 时分秒分隔符
 * @return yyyy-MM-dd HH:mm:ss
 * @author jye
 * @since 1.0
 */
fun Int.toYYYYMMDDHHMMSS(separator1: CharSequence = "-", separator2: CharSequence = ":"): String {
    val dateFormat = SimpleDateFormat(
        "yyyy${separator1}MM${separator1}dd HH${separator2}mm${separator2}ss",
        Locale.CHINA
    )
    return dateFormat.format(this)
}

/**
 * 转换为yyyy-MM-dd HH:mm格式（分隔符可替换）
 *
 * @param separator1 年月日分隔符
 * @param separator2 时分秒分隔符
 * @return yyyy-MM-dd HH:mm
 * @author jye
 * @since 1.0
 */
fun Long.toYYYYMMDDHHMM(separator1: CharSequence = "-", separator2: CharSequence = ":"): String {
    val dateFormat =
        SimpleDateFormat("yyyy${separator1}MM${separator1}dd HH${separator2}mm", Locale.CHINA)
    return dateFormat.format(this)
}

/**
 * 转换为yyyy-MM-dd HH:mm格式（分隔符可替换）
 *
 * @param separator1 年月日分隔符
 * @param separator2 时分秒分隔符
 * @return yyyy-MM-dd HH:mm
 * @author jye
 * @since 1.0
 */
fun Int.toYYYYMMDDHHMM(separator1: CharSequence = "-", separator2: CharSequence = ":"): String {
    val dateFormat =
        SimpleDateFormat("yyyy${separator1}MM${separator1}dd HH${separator2}mm", Locale.CHINA)
    return dateFormat.format(this)
}

/**
 * 转换为yyyy-MM-dd格式（分隔符可替换）
 *
 * @param separator 年月日分隔符
 * @return yyyy-MM-dd
 * @author jye
 * @since 1.0
 */
fun Long.toYYYYMMDD(separator: CharSequence = "-"): String {
    val dateFormat = SimpleDateFormat("yyyy${separator}MM${separator}dd", Locale.CHINA)
    return dateFormat.format(this)
}

/**
 * 转换为yyyy-MM-dd格式（分隔符可替换）
 *
 * @param separator 年月日分隔符
 * @return yyyy-MM-dd
 * @author jye
 * @since 1.0
 */
fun Int.toYYYYMMDD(separator: CharSequence = "-"): String {
    val dateFormat = SimpleDateFormat("yyyy${separator}MM${separator}dd", Locale.CHINA)
    return dateFormat.format(this)
}

/**
 * 格式化时间
 *
 * @param pattern 时间文本格式
 * @return 格式化后的时间字符串
 * @author jye
 * @since 1.0
 */
fun Long.formatTime(pattern: String): String {
    val dateFormat = SimpleDateFormat(pattern, Locale.CHINA)
    return dateFormat.format(this)
}

/**
 * 格式化时间
 *
 * @param pattern 时间文本格式
 * @return 格式化后的时间字符串
 * @author jye
 * @since 1.0
 */
fun Int.formatTime(pattern: String): String {
    val dateFormat = SimpleDateFormat(pattern, Locale.CHINA)
    return dateFormat.format(this)
}