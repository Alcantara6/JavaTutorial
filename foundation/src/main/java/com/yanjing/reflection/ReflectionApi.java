package com.yanjing.reflection;

import org.springframework.util.ObjectUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanjing
 * @date 2022/9/28
 */
public class ReflectionApi {

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Pojo pojo1 = new Pojo(1, 1, "Z", true);
        Pojo pojo2 = new Pojo(2, 2, null, false);
        List<Pojo> pojos = Arrays.asList(pojo1, pojo2);
        ReflectionApi api = new ReflectionApi();
        Pojo newPojo = api.combinePojos(pojos);
        System.out.println("newPojo is:" + newPojo);
        System.out.println(pojos.get(0));
        System.out.println(pojos.get(1));
    }

    public Pojo combinePojos(List<Pojo> pojoList) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        if (ObjectUtils.isEmpty(pojoList)) {
            return null;
        }
        Pojo newPojo = new Pojo();
        Field[] fields = Pojo.class.getDeclaredFields();
        for (Field field : fields) {
            // exclude final field
            if (java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                continue;
            }
            // field.setAccessible(true);
            List<Object> values = pojoList.stream().map(o -> {
                try {
                    return invokeGetter(o, field.getName());
                } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
            for (int i = 0; i < values.size(); i++) {
                // if value is null, we will change it to N
                if (ObjectUtils.isEmpty(values.get(i))) {
                    values.set(i, "N");
                }
            }
            Object maxValue = values.stream().max(Comparator.comparingInt(Object::hashCode)).orElse(null);
            // ReflectionUtils.setField(field, newPojo, maxValue);
            invokeSetter(newPojo, field.getName(), maxValue);
        }
        return newPojo;
    }

    public void invokeSetter(Object obj, String propertyName, Object variableValue) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor pd;
        pd = new PropertyDescriptor(propertyName, obj.getClass());
        Method setter = pd.getWriteMethod();
        setter.invoke(obj, variableValue);
    }

    public Object invokeGetter(Object obj, String variableName) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor pd = new PropertyDescriptor(variableName, obj.getClass());
        Method getter = pd.getReadMethod();
        System.out.println(getter.getName());
        Object f = getter.invoke(obj);
        return f;
    }
}
