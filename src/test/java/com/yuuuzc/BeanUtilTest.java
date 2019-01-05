package com.yuuuzc;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.yuuuzc.commons.beanutils.BeanUtil;
import com.yuuuzc.commons.classutils.ClassUtil;

public class BeanUtilTest {

    @Test
    public void test() throws IllegalAccessException, InvocationTargetException {
        System.out.println("BeanUtils.populate(bean, properties);");
        Map<String, String> properties = new HashMap<>();
        properties.put("a", "1");
        properties.put("b", "2");
        properties.put("c", "3");
        Demo bean = new Demo();
        BeanUtils.populate(bean, properties);
        System.out.println(bean);
    }

    @Test
    public void test1() {
        System.out.println("BeanUtil.newInstance(properties, Demo.class);");
        Map<String, String> properties = new HashMap<>();
        properties.put("a", "1");
        properties.put("b", "2");
        properties.put("c", "3");
        Demo bean = BeanUtil.newInstance(properties, Demo.class);
        System.out.println(bean);
    }

    @Test
    public void test2() {
        System.out.println("BeanUtil.populate(bean, properties)");
        Map<String, String> properties = new HashMap<>();
        properties.put("a", "1");
        properties.put("b", "2");
        properties.put("c", "3");
        Demo bean = new Demo();
        BeanUtil.populate(bean, properties);
        System.out.println(bean);
    }

    @Test
    public void test3() {
        System.out.println("ClassUtil.newInstance(properties, clazz);");
        Map<String, String> properties = new HashMap<>();
        properties.put("a", "1");
        properties.put("b", "2");
        properties.put("c", "3");
        Demo bean = ClassUtil.newInstance(properties, Demo.class);
        System.out.println(bean);
    }

}
