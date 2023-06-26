package com.jye.devkit.base.cache.spcache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jye.devkit.base.cache.DkCache;


/**
 * @author jye
 * @since 1.0
 */
public class SPValueWrapper extends DkCache.ValueWrapper {

    public SPValueWrapper(@Nullable Object value) {
        super(value);
    }

    @Override
    public int asInt(int defValue) {
        String value = asString("");
        if (!value.isEmpty()) {
            return Integer.parseInt(value);
        }
        return defValue;
    }

    @Override
    public long asLong(long defValue) {
        String value = asString("");
        if (!value.isEmpty()) {
            return Long.parseLong(value);
        }
        return defValue;
    }

    @Override
    public float asFloat(float defValue) {
        String value = asString("");
        if (!value.isEmpty()) {
            return Float.parseFloat(value);
        }
        return defValue;
    }

    @Override
    public boolean asBoolean(boolean defValue) {
        String value = asString("");
        if (!value.isEmpty()) {
            return Boolean.parseBoolean(value);
        }
        return defValue;
    }

    @NonNull
    @Override
    public String asString(@NonNull String defValue) {
        return value != null ? value.toString() : defValue;
    }
}
