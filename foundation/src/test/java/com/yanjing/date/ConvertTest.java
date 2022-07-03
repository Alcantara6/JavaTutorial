package com.yanjing.date;

import org.junit.jupiter.api.Test;

import java.time.*;

/**
 * @author yanjing
 * @date 2022/7/3
 */
public class ConvertTest {

    /**
     * toInstant
     * ofInstant
     */
    static class InstantTest {

        @Test
        public void local2Offset() {

            LocalDateTime localDateTime = LocalDateTime.of(2021, 1, 17, 18, 0, 0);
            System.out.println("当前时区（北京）时间为：" + localDateTime);

            // 北京时间晚上18:00 对应的-4地方的时间点
            Instant instant = localDateTime.toInstant(ZoneOffset.ofHours(8));
            System.out.println("instant: " + instant);
            OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, ZoneOffset.ofHours(-4));
            System.out.println("offsetDateTime-4: " + offsetDateTime);
        }

        @Test
        public void local2Zone() {

            LocalDateTime localDateTime = LocalDateTime.of(2021, 1, 17, 18, 0, 0);
            System.out.println("当前时区（北京）时间为：" + localDateTime);

            // 北京时间晚上18:00 对应的-4地方的时间点
            Instant instant = localDateTime.toInstant(ZoneOffset.ofHours(8));
            System.out.println("instant: " + instant);
            ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneOffset.ofHours(-4));
            System.out.println("zonedDateTime-4: " + zonedDateTime);
        }

        @Test
        public void instant() {
            // 时间戳类型，UTC当前时间
            System.out.println("Instant.now(): " + Instant.now());
            // 时间戳类型，毫秒表示
            System.out.println("Instant.now().toEpochMilli(): " + Instant.now().toEpochMilli());
            // 指定时区的时间点相距1970-01-01零时的时间戳
            // toInstant： The calculation combines the local date-time and offset.
            System.out.println("LocalDateTime.now() with systemDefaultZone to toEpochMilli: "
                    + LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
            // 表示从1970-01-01 00:00:00开始后两分钟的10万纳秒的时刻
            System.out.println("Instant.ofEpochSecond(120, 100000): "
                    + Instant.ofEpochSecond(120, 100000));
        }
    }

    @Test
    public void offset2Local() {

        OffsetDateTime offsetDateTime = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(-4));
        System.out.println("-4偏移量时间为：" + offsetDateTime);

        // 转为LocalDateTime 注意：时间还是未变的哦
        System.out.println("LocalDateTime的表示形式：" + offsetDateTime.toLocalDateTime());
    }

    /**
     * 非重点
     * atZoneSameInstant()：将此日期时间与时区结合起来创建ZonedDateTime，以确保结果具有相同的Instant
     * 所有偏移量-4 -> -5，时间点也从19 -> 18，确保了Instant保持一致嘛
     * atZoneSimilarLocal：将此日期时间与时区结合起来创建ZonedDateTime，以确保结果具有相同的本地时间
     * 所以直接效果和toLocalDateTime()是一样的，但是它会尽可能的保留偏移量（所以你看-4变为了-5，保持了真实的偏移量）
     */
    @Test
    public void offset2Zone() {

        LocalDateTime time = LocalDateTime.of(2021, 1, 17, 19, 43, 28);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(time, ZoneOffset.ofHours(-4));
        System.out.println("-4偏移量时间为：" + offsetDateTime);

        // 转换为ZonedDateTime的表示形式
        System.out.println("toZonedDateTime：" + offsetDateTime.toZonedDateTime());
        // New_York是西五区
        System.out.println("atZoneSameInstant：" + offsetDateTime.atZoneSameInstant(ZoneId.of("America/New_York")));
        System.out.println("atZoneSimilarLocal：" + offsetDateTime.atZoneSimilarLocal(ZoneId.of("America/New_York")));
    }
}
