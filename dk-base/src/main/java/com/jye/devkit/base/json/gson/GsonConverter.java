package com.jye.devkit.base.json.gson;

import com.google.gson.Gson;
import com.jye.devkit.base.json.IConverter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Gson实现的Json转换器
 *
 * @author jye
 * @since 1.0
 */
public class GsonConverter implements IConverter {

    private final Gson gson = GsonFactory.get();

    @Override
    public String objectToJson(Object object) {
        return gson.toJson(object);
    }

    @Override
    public <T> T jsonToObject(String json, Class<T> cls) {
        return gson.fromJson(json, cls);
    }

    @Override
    public <T> T jsonToObject(String json, Type type) {
        return gson.fromJson(json, type);
    }

    @Override
    public <T> List<T> jsonToList(String json, Class<T> cls) {
        Type type = new ParameterizedTypeImpl(cls);
        return gson.fromJson(json, type);
    }

    private static class ParameterizedTypeImpl implements ParameterizedType {

        private Class clazz;

        public ParameterizedTypeImpl(Class clz) {
            clazz = clz;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{clazz};
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }

    }

}
