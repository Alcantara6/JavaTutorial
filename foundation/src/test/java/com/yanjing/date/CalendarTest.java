package com.yanjing.date;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

/**
 * @author yanjing
 * @date 2022/12/8
 */
public class CalendarTest {

    @Test
    void test() {
        Calendar instance = Calendar.getInstance();
        int hour = instance.get(Calendar.HOUR_OF_DAY);
        long timeInMillis = instance.getTimeInMillis();
        System.out.println(hour);
        System.out.println(timeInMillis);

        instance.set(2004, Calendar.JANUARY, 7, 15, 40);
        instance.add(Calendar.DATE, 35);
        // 增加日，并会跨越到下个月
        System.out.println(instance.get(Calendar.MONTH));
        System.out.println(instance.get(Calendar.DATE));
        // 只会增加日
        instance.roll(Calendar.DATE, 35);
        System.out.println(instance.get(Calendar.MONTH));
        System.out.println(instance.get(Calendar.DATE));
        instance.set(Calendar.MONTH, 3);
        System.out.println(instance.get(Calendar.MONTH));
        System.out.println(instance.get(Calendar.DATE));
    }
}
