package com.jye.devkit.base.cache;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jye.devkit.base.cache.achache.ACache;
import com.jye.devkit.base.cache.spcache.SPCache;
import com.jye.devkit.base.cache.spcache.util.SecuritySharedPreference;
import com.jye.devkit.base.DkBase;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 缓存管理类
 *
 * @author jye
 * @since 1.0
 */
public class DkCacheManager {

    private static DkCacheManager sInstance = new DkCacheManager();

    private final Context mContext;

    private Map<String, DkCache> mCacheMap;

    public static DkCacheManager getInstance() {
        return sInstance;
    }

    private DkCacheManager() {
        this.mContext = DkBase.getAppContext();
        this.mCacheMap = new HashMap<>();
    }

    @Nullable
    public DkCache getCache(String name) {
        return mCacheMap.get(name);
    }

    public Collection<String> getCacheNames() {
        return mCacheMap.keySet();
    }

    public void addCache(String name, DkCache cache) {
        mCacheMap.put(name, cache);
    }

    public void removeCache(String name) {
        mCacheMap.remove(name);
    }

    //==============================================================================================
    //SPCache
    //==============================================================================================

    /**
     * 返回明文存储的SPCache，Mode默认为MODE_PRIVATE
     *
     * @param name 存储文件名称
     */
    @NonNull
    public SPCache spCache(String name) {
        return spCache(name, Context.MODE_PRIVATE);
    }

    /**
     * 返回明文存储的SPCache，Mode为指定的类型
     *
     * @param name 存储文件名称
     * @param mode 存储模式（默认MODE_PRIVATE）
     */
    @NonNull
    public SPCache spCache(String name, int mode) {
        DkCache cache = getCache(name);
        if (cache == null) {
            cache = new SPCache(mContext.getSharedPreferences(name, mode));
            addCache(name, cache);
        }
        return (SPCache) cache;
    }

    /**
     * 返回密文存储的SPCache，Mode默认为MODE_PRIVATE
     *
     * @param name 存储文件名称
     */
    @NonNull
    public SPCache securitySpCache(String name) {
        return securitySpCache(name, Context.MODE_PRIVATE);
    }

    /**
     * 返回密文存储的SPCache，Mode为指定的类型
     *
     * @param name 存储文件名称
     * @param mode 存储模式（默认MODE_PRIVATE）
     */
    @NonNull
    public SPCache securitySpCache(String name, int mode) {
        DkCache cache = getCache(name);
        if (cache == null) {
            cache = new SPCache(new SecuritySharedPreference(mContext, name, mode));
            addCache(name, cache);
        }
        return (SPCache) cache;
    }

    //==============================================================================================
    //ASimpleCache
    //==============================================================================================

    /**
     * 返回ACache实例
     *
     * @param fileName 缓存文件名
     * @return ACache
     */
    @NonNull
    public ACache aCache(String fileName) {
        return ACache.get(mContext, fileName);
    }

    /**
     * 返回ACache实例
     *
     * @param fileName 缓存文件名
     * @param maxSize  缓存内存限制
     * @param maxCount 缓存数量限制
     * @return ACache
     */
    @NonNull
    public ACache aCache(String fileName, long maxSize, int maxCount) {
        File cacheDir = new File(mContext.getCacheDir(), fileName);
        return ACache.get(cacheDir, maxSize, maxCount);
    }

}
