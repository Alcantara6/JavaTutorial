package com.yanjing.date;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * @author yanjing
 * @date 2022/7/2
 */
public class LocalTest {

    @Test
    public void now() {

        System.out.println("============Local===============");
        // 方式一：普通做法
        System.out.println("LocalDateTime.now(): " + LocalDateTime.now());
        // 方式二：最佳实践
        System.out.println("LocalDateTime.now(oneId.systemDefault()): " + LocalDateTime.now(ZoneId.systemDefault()));

        System.out.println("纽约时区的本地时间：" + LocalDateTime.now(ZoneId.of("America/New_York")));
    }

    @Test
    public void format() {

        // 格式化日期
        System.out.println("==========================格式化日期===========================================");
        System.out.println("format DateTimeFormatter.ISO_DATE_TIME: " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("DateTimeFormatter.ISO_LOCAL_DATE_TIME.format:" + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
        System.out.println("format DateTimeFormatter.ofPattern: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    @Test
    public void parse() {

        // 不指定formatter，默认DateTimeFormatter.ISO_LOCAL_DATE_TIME
        String dateTimeStr = "2021-01-04T17:39:30";
        System.out.println("parse: " + LocalDateTime.parse(dateTimeStr));
        // 指定formatter
        dateTimeStr = "2021-01-04 17:39:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("parse DateTimeFormatter.ofPattern: " + LocalDateTime.parse(dateTimeStr, formatter));
    }

    @Test
    public void builtInFormatter() {

        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
        System.out.println("格式化输出（本地化输出，中文环境）：" +
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT).format(now));
    }

    @Test
    public void dateTimeFormatterWithLocale() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("第Q季度 yyyy-MM-dd HH:mm:ss", Locale.US);

        // 格式化输出
        System.out.println("LocalDateTime.now() format, " + formatter.format(LocalDateTime.now()));

        // 解析
        String dateTimeStrParam = "第1季度 2021-01-17 22:51:32";
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStrParam, formatter);
        System.out.println("解析后的结果：" + localDateTime);
    }

    /**
     * 指定日期时间
     */
    @Test
    public void localOf() {

        LocalDateTime ldt1 = LocalDateTime.of(2021, Month.JANUARY, 2, 17, 23, 52);

        System.out.println("LocalDateTime.of: " + ldt1);
        LocalDate localDate = LocalDate.of(2021, Month.JANUARY, 2);
        LocalTime localTime = LocalTime.of(17, 23, 59);
        LocalDateTime ldt2 = localDate.atTime(localTime);
        System.out.println("localDate.atTime(localTime): " + ldt2);
        LocalDateTime ldt3 = LocalDateTime.of(localDate, localTime);
        System.out.println("LocalDateTime.of(localDate, localTime): " + ldt3);

        // 获取具体哪一年、月、天……
        System.out.println("getDayOfMonth(): " + ldt2.getDayOfMonth());
        System.out.println("getMonth(): " + ldt2.getMonth());
    }

    @Test
    public void calculateTemporalAdjusters() {
        // 增加和减少日期
        System.out.println("==========================增加和减少日期===========================================");
        // 加3天
        System.out.println("plusDays: " + LocalDateTime.now().plusDays(3));
        System.out.println("TemporalAdjusters.nextOrSame: " + LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)));
        System.out.println("TemporalAdjusters.lastInMonth: " + LocalDate.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.SATURDAY)));
    }

    @Test
    public void duration() {

        LocalDateTime ldt1 = LocalDateTime.of(2021, Month.JANUARY, 2, 17, 23, 52);
        LocalDateTime ldt2 = LocalDateTime.of(2021, Month.JANUARY, 2, 17, 24, 0);

        System.out.println("=============Duration=============");
        System.out.println("Duration.between: " + Duration.between(ldt1, ldt2).toSeconds());
        System.out.println("Duration.of Days: " + Duration.of(5, ChronoUnit.DAYS).toDays());
        System.out.println("Duration.of MILLIS: " + Duration.of(1000, ChronoUnit.MILLIS).toMillis());
    }

    /**
     * Period在概念上和Duration类似，区别在于Period是以年月日来衡量一个时间段
     */
    @Test
    public void period() {
        System.out.println("=============Period================");
        System.out.println("Period.of(): " + Period.of(2, 3, 6).getDays());
        System.out.println("Period.between():" + Period.between(
                    LocalDate.of(2021, 1, 4),
                    LocalDate.of(2021, 1, 5)
                ).getDays()
        );
    }
}
