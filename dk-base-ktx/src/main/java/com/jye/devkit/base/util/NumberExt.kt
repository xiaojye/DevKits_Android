package com.jye.devkit.base.util

import java.math.BigDecimal
import java.math.RoundingMode

/**
 * @author jye
 * @since 1.0
 */
fun Double.formatDecimal(digit: Int, roundingMode: RoundingMode = RoundingMode.FLOOR): String {
    return NumberUtils.format(
        this.toString(),
        digit,
        roundingMode
    )
}

/**
 * @author jye
 * @since 1.0
 */
fun Long.formatDecimal(digit: Int, roundingMode: RoundingMode = RoundingMode.FLOOR): String {
    return NumberUtils.format(
        this.toString(),
        digit,
        roundingMode
    )
}

/**
 * @author jye
 * @since 1.0
 */
fun String.formatDecimal(digit: Int, roundingMode: RoundingMode = RoundingMode.FLOOR): String {
    return NumberUtils.format(this, digit, roundingMode)
}

/**
 * @author jye
 * @since 1.0
 */
fun Double.toTwoDecimal(roundingMode: RoundingMode = RoundingMode.FLOOR): String {
    return this.formatDecimal(2, roundingMode)
}

/**
 * @author jye
 * @since 1.0
 */
fun Long.toTwoDecimal(roundingMode: RoundingMode = RoundingMode.FLOOR): String {
    return this.formatDecimal(2, roundingMode)
}

/**
 * @author jye
 * @since 1.0
 */
fun String.toTwoDecimal(roundingMode: RoundingMode = RoundingMode.FLOOR): String {
    return this.formatDecimal(2, roundingMode)
}

/**
 * @author jye
 * @since 1.0
 */
fun String.toDoubleTryCatch(normal: Double = 0.0): Double {
    return try {
        this.toDouble()
    } catch (e: Exception) {
        normal
    }
}

/**
 * @author jye
 * @since 1.0
 */
fun Double.toBigDecimalTryCatch(normal: Double = 0.0): BigDecimal {
    return try {
        this.toBigDecimal()
    } catch (e: Exception) {
        normal.toBigDecimal()
    }
}

/**
 * @author jye
 * @since 1.0
 */
fun Long.toBigDecimalTryCatch(normal: Double = 0.0): BigDecimal {
    return try {
        this.toBigDecimal()
    } catch (e: Exception) {
        normal.toBigDecimal()
    }
}

/**
 * @author jye
 * @since 1.0
 */
fun String.toBigDecimalTryCatch(normal: Double = 0.0): BigDecimal {
    return try {
        this.toBigDecimal()
    } catch (e: Exception) {
        normal.toBigDecimal()
    }
}

/**
 * 加法
 *
 * @param number 加数
 * @return 加法运算后的结果（和）
 * @author jye
 * @since 1.0
 */
fun Double.add(number: Double): String {
    return NumberUtils.add(this, number).toPlainString()
}

/**
 * 加法
 *
 * @param number 加数
 * @return 加法运算后的结果（和）
 * @author jye
 * @since 1.0
 */
fun Long.add(number: Long): String {
    return NumberUtils.add(this, number).toPlainString()
}

/**
 * 加法
 *
 * @param number 加数
 * @return 加法运算后的结果（和）
 * @author jye
 * @since 1.0
 */
fun String.add(number: String): String {
    return NumberUtils.add(this, number).toPlainString()
}

/**
 * 减法
 *
 * @param number 减数
 * @return 减法运算后的结果（差）
 * @author jye
 * @since 1.0
 */
fun Double.sub(number: Double): String {
    return NumberUtils.sub(this, number).toPlainString()
}

/**
 * 减法
 *
 * @param number 减数
 * @return 减法运算后的结果（差）
 * @author jye
 * @since 1.0
 */
fun Long.sub(number: Long): String {
    return NumberUtils.sub(this, number).toPlainString()
}

/**
 * 减法
 *
 * @param number 减数
 * @return 减法运算后的结果（差）
 * @author jye
 * @since 1.0
 */
fun String.sub(number: String): String {
    return NumberUtils.sub(this, number).toPlainString()
}

/**
 * 乘法
 *
 * @param number 乘数（因数）
 * @return 乘法运算后的结果（积）
 * @author jye
 * @since 1.0
 */
fun Double.mul(number: Double): String {
    return NumberUtils.mul(this, number).toPlainString()
}

/**
 * 乘法
 *
 * @param number 乘数（因数）
 * @return 乘法运算后的结果（积）
 * @author jye
 * @since 1.0
 */
fun Long.mul(number: Long): String {
    return NumberUtils.mul(this, number).toPlainString()
}

/**
 * 乘法
 *
 * @param number 乘数（因数）
 * @return 乘法运算后的结果（积）
 * @author jye
 * @since 1.0
 */
fun String.mul(number: String): String {
    return NumberUtils.mul(this, number).toPlainString()
}

/**
 * 除法
 *
 * @param number 除数
 * @param scale 小数位数
 * @return 除法运算后的结果
 * @author jye
 * @since 1.0
 */
fun Double.divide(number: Double, scale: Int): String {
    return NumberUtils.divide(this, number, scale).toPlainString()
}

/**
 * 除法
 *
 * @param number 除数
 * @param scale 小数位数
 * @return 除法运算后的结果
 * @author jye
 * @since 1.0
 */
fun Long.divide(number: Long, scale: Int): String {
    return NumberUtils.divide(this, number, scale).toPlainString()
}

/**
 * 除法
 *
 * @param number 除数
 * @param scale 小数位数
 * @return 除法运算后的结果
 * @author jye
 * @since 1.0
 */
fun String.divide(number: String, scale: Int): String {
    return NumberUtils.divide(this, number, scale).toPlainString()
}


/**
 * 去除小数末尾的0
 *
 * @return 去除小数末尾的0后的数字
 * @author jye
 * @since 1.0
 */
fun Double.stripTrailingZeros(): String {
    return NumberUtils.stripTrailingZeros(this)
}

/**
 * 去除小数末尾的0
 *
 * @return 去除小数末尾的0后的数字
 * @author jye
 * @since 1.0
 */
fun Long.stripTrailingZeros(): String {
    return NumberUtils.stripTrailingZeros(this)
}

/**
 * 去除小数末尾的0
 *
 * @return 去除小数末尾的0后的数字
 * @author jye
 * @since 1.0
 */
fun String.stripTrailingZeros(): String {
    return NumberUtils.stripTrailingZeros(this)
}