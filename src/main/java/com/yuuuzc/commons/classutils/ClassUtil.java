package com.yuuuzc.commons.classutils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class ClassUtil {

    public static <T> T newInstance(Map<?, ?> params, Class<T> clazz) {
        try {
            T o = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (params.get(field.getName()) != null) {
                    Method method = getSetMethod(o, field.getName());
                    method.invoke(o, (Object) params.get(field.getName()));
                }
            }
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unused")
    private static Method getGetMethod(Object obj, String fieldName)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods) {
            if (("get" + fieldName).toLowerCase().equals(method.getName().toLowerCase()))
                return method;
            return method;
        }
        return null;
    }

    private static Method getSetMethod(Object obj, String fieldName)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods) {
            if (("set" + fieldName).toLowerCase().equals(method.getName().toLowerCase()))
                return method;
        }
        return null;
    }

}
