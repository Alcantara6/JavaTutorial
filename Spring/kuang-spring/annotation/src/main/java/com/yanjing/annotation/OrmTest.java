package com.yanjing.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author yanjing
 * @date 2022/3/20
 */
public class OrmTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class<?> entity = Class.forName("com.yanjing.annotation.OrmEntity");
        // getAnnotations
        Annotation[] annotations = entity.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // getAnnotation
        OrmTable ormTable = entity.getAnnotation(OrmTable.class);
        System.out.println(ormTable.value());

        Field age = entity.getDeclaredField("age");
        OrmField ormField = age.getAnnotation(OrmField.class);
        System.out.println(ormField.column());
        System.out.println(ormField.type());
        System.out.println(ormField.length());
    }
}
