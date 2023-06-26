package com.jye.devkit.base.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.JsonParseException;
import com.jye.devkit.base.json.DkJson;

import java.util.List;
import java.util.Map;

/**
 * @author jye
 * @since 1.0
 */
public interface DkCache {

    @NonNull
    ValueWrapper get(String key);

    void put(String key, @Nullable Object value);

    void put(String key, @Nullable Object value, int ttl);

    void remove(String key);

    Map<String, ValueWrapper> getAll();

    void clear();

    abstract class ValueWrapper {

        @Nullable
        protected final Object value;

        public ValueWrapper(@Nullable Object value) {
            this.value = value;
        }

        @Nullable
        public Object value() {
            return this.value;
        }

        public abstract int asInt(int defValue);

        public abstract long asLong(long defValue);

        public abstract float asFloat(float defValue);

        public abstract boolean asBoolean(boolean defValue);

        @NonNull
        public abstract String asString(@NonNull String defValue);

        @Nullable
        public <T> T asObject(Class<T> clz) {
            String json = asString("");
            if (!json.isEmpty()) {
                try {
                    return DkJson.parseObject(json, clz);
                } catch (JsonParseException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Nullable
        public <T> List<T> asList(Class<T> clz) {
            String json = asString("");
            if (!json.isEmpty()) {
                try {
                    return DkJson.parseArray(json, clz);
                } catch (JsonParseException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

}
