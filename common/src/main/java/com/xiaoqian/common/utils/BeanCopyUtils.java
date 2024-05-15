package com.xiaoqian.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {
    public BeanCopyUtils() {}

    /**
     * 单个实体类的拷贝，第一个参数是要源对象，第二个参数是目标类的字节码对象。
     */
    // <V>声明该方法为泛型方法， V表示返回值类型，Class<V>固定了参数类型以及返回值类型
    public static <V> V copyBean(Object source, Class<V> clazz) {
        V v;
        try {
            v = clazz.newInstance();// 通过反射创建实例
            BeanUtils.copyProperties(source, v);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return v;
    }

    /**
     * 集合的拷贝，第一个参数是要源集合，第二个参数是 目标类的字节码对象。
     */
    // <S,V>声明该方法为泛型方法，且有两个泛型参数，List<V>表示返回值类型
    // List<S>固定了源参数类型，Class<V>固定了参数类型以及返回值类型
    public static <S, V> List<V> copyBeanList(List<S> source, Class<V> clazz) {
        return source.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }
}
