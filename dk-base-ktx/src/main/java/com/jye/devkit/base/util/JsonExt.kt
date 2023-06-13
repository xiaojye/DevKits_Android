package com.jye.devkit.base.util

import com.jye.devkit.base.json.DkJson
import org.json.JSONArray
import org.json.JSONObject

/**
 * 用于将一个对象转换为JSON字符串
 *
 * @return JSON字符串
 */
fun Any.toJsonString(): String {
    if (this is JSONObject || this is JSONArray) {
        return this.toString()
    }
    return com.jye.devkit.base.json.DkJson.toJsonString(this)
}

/**
 * 用于将一个JSON字符串转换为对象
 *
 * @param clazz 对象类名
 * @return 转换的对象实例
 */
fun <T> String.parseObject(clazz: Class<T>): T {
    return com.jye.devkit.base.json.DkJson.parseObject(this, clazz)
}

/**
 * 用于将一个JSON字符串转换为List
 *
 * @param clazz List的泛型对象类名
 * @return 转换的List实例
 */
fun <T> String.parseArray(clazz: Class<T>): List<T> {
    return com.jye.devkit.base.json.DkJson.parseArray(this, clazz)
}

/**
 * JSON字符串转JSONObject
 *
 * @return JSONObject实例
 */
fun String.toJSONObject(): JSONObject {
    return JSONObject(this)
}

/**
 * JSON字符串转JSONArray
 *
 * @return JSONArray实例
 */
fun String.toJSONArray(): JSONArray {
    return JSONArray(this)
}