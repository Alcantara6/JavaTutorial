package com.yanjing.reflection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author yanjing
 * @date 2023/1/5
 */
public class FieldsAndGetterReflection {

    public static void main(String[] args) throws IllegalAccessException {
        Pojo2 pojo = new Pojo2();
        for (Field field : pojo.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(pojo);
            System.out.println("filed: " + field.getName() + " is: " + value);
        }

        Pojo2 pojo2 = new Pojo2();
        FieldsAndGetterReflection instance = new FieldsAndGetterReflection();
        List<Object> results = instance.obtainGettersValues(pojo2);
        for (Object result : results) {
            System.out.println("xxxxxx" + result);
        }
    }

    private <T> List<Object> obtainGettersValues(T bean) {
        LinkedList<Object> values = new LinkedList<>();
        ReflectionUtils.doWithMethods(bean.getClass(), method -> {
            try {
                Object value = method.invoke(bean);
                values.add(value);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }, this::isGetter);
        return values;
    }

    private boolean isGetter(Method method) {
        return Modifier.isPublic(method.getModifiers())
                && !Modifier.isNative(method.getModifiers())
                && (method.getName().startsWith("get") || method.getName().startsWith("is"))
                && method.getParameterCount() == 0
                && method.getReturnType() != Void.class
                && Objects.isNull(method.getAnnotation(JsonIgnore.class));
    }
}
