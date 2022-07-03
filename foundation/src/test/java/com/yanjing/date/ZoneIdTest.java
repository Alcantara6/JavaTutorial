package com.yanjing.date;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.TimeZone;

/**
 * @author yanjing
 * @date 2022/7/2
 * ZoneId并没有提供设置默认时区的方法,设置默认时区方式完全遵照TimeZone的方式即可
 */
public class ZoneIdTest {

    @Test
    public void zoneId() {

        System.out.println("==========================时区ZoneId===========================================");
        System.out.println("ZoneId.getAvailableZoneIds()" + ZoneId.getAvailableZoneIds());
        // JDK 1.8之前做法
        System.out.println(TimeZone.getDefault());
        System.out.println("ZoneId.systemDefault()： " + ZoneId.systemDefault());
        System.out.println("ZoneId.of(\"Asia/Paris\"): " + ZoneId.of("Europe/Paris"));

        // ZoneId.from
        System.out.println("ZoneId.from(ZonedDateTime.now()), " + ZoneId.from(ZonedDateTime.now()));
        System.out.println("ZoneId.from(ZoneOffset.of(\"+8\")), " + ZoneId.from(ZoneOffset.of("+8")));

        // 报错：java.time.DateTimeException: Unable to obtain ZoneId from TemporalAccessor:
        // System.out.println(ZoneId.from(LocalDateTime.now()));
        // System.out.println(ZoneId.from(LocalDate.now()));

        // 根据偏移量得到的ZoneId内部并无现成时区规则可用，因此对于有夏令营的国家转换可能出问题，一般不建议这么去做。
        System.out.println("根据偏移量ZoneId.ofOffset(+8): " + ZoneId.ofOffset("UTC", ZoneOffset.of("+8")));
        System.out.println("根据偏移量ZoneId.ofOffset(Z): " + ZoneId.ofOffset("UTC", ZoneOffset.of("Z")));
    }

    @Test
    public void zoneOffset() {

        System.out.println("最小偏移量：" + ZoneOffset.MIN);
        System.out.println("最小偏移量：" + ZoneOffset.MAX);
        System.out.println("中心偏移量：" + ZoneOffset.UTC);
        // 超出最大范围
        // System.out.println(ZoneOffset.of("+20"));

        // 通过时分秒构造偏移量（使用很方便，推荐）
        System.out.println(ZoneOffset.ofHours(8));
        System.out.println(ZoneOffset.ofHoursMinutes(8, 8));
        System.out.println(ZoneOffset.ofHoursMinutesSeconds(8, 8, 8));
        // 指定一个精确的秒数  获取实例（有时候也很有用处）
        System.out.println(ZoneOffset.ofTotalSeconds(8 * 60 * 60));
    }

    @Test
    public void zonedDateTime() {

        System.out.println("========================带时区的时间ZonedDateTime===================================");
        // 使用系统时区
        System.out.println("ZonedDateTime.now()," + ZonedDateTime.now());
        // 自己指定时区 America
        System.out.println("ZonedDateTime.now() America, " + ZonedDateTime.now(ZoneId.of("America/New_York")));
        // 自己指定时区 UTC
        System.out.println("ZonedDateTime.now() Clock.systemUTC(), " + ZonedDateTime.now(Clock.systemUTC()));
        // 指定时区的时间等于当前系统的
        System.out.println("ZonedDateTime.of() Shanghai, " + ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Shanghai")));
        // 指定时区的时间等于当前系统的 America
        System.out.println("ZonedDateTime.of() America, " + ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/New_York")));
        System.out.println("LocalDateTime.now().atZone, " + LocalDateTime.now().atZone(ZoneId.of("America/New_York")));
    }

    @Test
    public void offsetDateTime() {

        System.out.println("========================时区OffsetDateTime===================================");
        // 使用系统时区
        System.out.println("OffsetDateTime.now()," + OffsetDateTime.now()); // 使用系统时区
        // 自己指定时区 America
        System.out.println("OffsetDateTime.now() America, " + OffsetDateTime.now(ZoneId.of("America/New_York"))); // 自己指定时区
        // 自己指定时区 UTC
        System.out.println("OffsetDateTime.now() UTC, " + OffsetDateTime.now(Clock.systemUTC())); // 自己指定时区
        // 指定时区的时间等于当前系统的
        System.out.println("OffsetDateTime.of(-4): " + OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("-04:00")));
        // 指定时区的时间等于当前系统的 America
        System.out.println("OffsetDateTime.of(UTC): " + OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.UTC));
        System.out.println("LocalDateTime.now().atOffset: " + LocalDateTime.now().atOffset(ZoneOffset.of("Z")));
    }

    @Test
    public void parseWithOffsetOrZone() {
        // 带偏移量 使用OffsetDateTime
        String dateTimeStrParam = "2021-05-05T18:00-04:00";
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateTimeStrParam);
        System.out.println("带偏移量解析后：" + offsetDateTime);

        // 带时区 使用ZonedDateTime
        dateTimeStrParam = "2021-05-05T18:00-05:00[America/New_York]";
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeStrParam);
        // 2021-05-05T19:00-04:00[America/New_York]，夏令时期间带时区解析后这个结果：字符串参数偏移量明明是-05，转换为ZonedDateTime后偏移量成为了-04
        System.out.println("带时区解析后：" + zonedDateTime);
    }
}
