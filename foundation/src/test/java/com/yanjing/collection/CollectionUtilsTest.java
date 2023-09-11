package com.yanjing.collection;


import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author yanjing
 * @date 2022/4/3
 */
public class CollectionUtilsTest {

    @Test
    void addIgnoreNullTest() {
        //null 元素不能加进去
        List<String> arrayList1 = new ArrayList<>();
        arrayList1.add("a");
        CollectionUtils.addIgnoreNull(arrayList1, null);
        System.out.println(arrayList1.size());
        arrayList1.add(null);
        System.out.println(arrayList1.size());
    }

    @Test
    void collateTest() {
        //排好序的集合，合并后还是排序的
        List<String> arrayList2 = new ArrayList<>();
        arrayList2.add("a");
        arrayList2.add("b");

        List<String> arrayList3 = new ArrayList<>();
        arrayList3.add("c");
        arrayList3.add("d");
        System.out.println("arrayList3：" + arrayList3);

        List<String> arrayList4 = CollectionUtils.collate(arrayList2, arrayList3);
        System.out.println("arrayList4:" + arrayList4);
    }

    @Test
    void retainTest() {

        //交集
        List<String> arrayList5 = new ArrayList<>();
        arrayList5.add("a");
        arrayList5.add("b");

        List<String> arrayList6 = new ArrayList<>();
        arrayList6.add("b");
        arrayList6.add("c");
        Collection<String> strings = CollectionUtils.retainAll(arrayList5, arrayList6);
        System.out.println("arrayList5和arrayList6的交集：" + strings);
    }

    @Test
    void retainUnionSubtractTest() {

        List<String> arrayList3 = new ArrayList<>();
        arrayList3.add("c");
        arrayList3.add("d");
        System.out.println("arrayList3：" + arrayList3);

        List<String> arrayList4 = new ArrayList<>();
        arrayList4.add("a");
        arrayList4.add("b");
        arrayList4.add("c");
        arrayList4.add("d");

        //交集
        Collection<String> strings = CollectionUtils.retainAll(arrayList4, arrayList3);
        System.out.println("arrayList3和arrayList4的交集：" + strings);

        //并集
        Collection<String> union = CollectionUtils.union(arrayList4, arrayList3);
        System.out.println("arrayList3和arrayList4的并集：" + union);

        //差集
        Collection<String> subtract = CollectionUtils.subtract(arrayList4, arrayList3);
        System.out.println("arrayList3和arrayList4的差集：" + subtract);

        //差集
        Collection<String> subtract2 = CollectionUtils.subtract(arrayList3, arrayList4);
        System.out.println("arrayList3和arrayList4的差集：" + subtract2);
    }

    @Test
    void filterTest() {

        List<String> arrayList4 = new ArrayList<>();
        arrayList4.add("a");
        arrayList4.add("b");

        // 过滤，只保留 b
        CollectionUtils.filter(arrayList4, s -> s.equals("b"));
        System.out.println(arrayList4);
    }

    @Test
    void addAndSetTest() {
        List<Integer> group1 = new ArrayList<>();
        group1.add(1);
        group1.add(null);
        group1.add(2);
        List<Integer> group2 = new ArrayList<>();
        group2.add(1);
        group2.add(null);
        group2.add(2);

        group1.add(1, 100);
        group1.add(2, 200);
        group2.set(1, 100);
        group2.set(2, 200);
        System.out.println(group1);
        System.out.println(group2);
    }
}