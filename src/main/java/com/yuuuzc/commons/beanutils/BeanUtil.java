package com.yuuuzc.commons.beanutils;

import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.beans.BeanMap;

public class BeanUtil {

    /**
     * *将对象转化为map
     * 
     * @param bean
     * @return <T> Map<?, ?>
     */
    public static <T> Map<?, ?> bean2Map(T bean) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * *根据properties和clazz生成一个新的bean
     * 
     * @param map
     * @param bean
     * @return <T> T
     */
    public static <T> T newInstance(Map<?, ?> properties, Class<T> clazz) {
        T bean = null;
        try {
            bean = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(properties);
        return bean;
    }

    /**
     * *根据properties填充bean
     * 
     * @param map
     * @param bean
     * @return
     */
    public static void populate(Object bean, Map<?, ?> properties) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(properties);
    }
}
