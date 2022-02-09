package date;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

/**
 * @author yanjing
 * @date 2021/11/2
 */
class PhoneCodeExpireTimerTest {

    @Test
    public void countExpireTime_happyPath() {

        Clock fixedClock = createFixedClock(LocalTime.of(23, 59, 57));
        PhoneCodeExpireTimer phoneCodeExpireTimer = new PhoneCodeExpireTimer(fixedClock);
        
        assertThat(phoneCodeExpireTimer.countExpireTime(), is(2));
        assertThat(phoneCodeExpireTimer.getCodeExpireSeconds(), is(120));
    }

    /**
     * Clock.fixed
     * Obtains a clock that always returns the same instant.
     * This clock simply returns the specified instant. As such, it is not a clock in the conventional sense. The main use case for this is in testing, where the fixed clock ensures tests are not dependent on the current clock.
     * The returned implementation is immutable, thread-safe and Serializable.
     * Params:
     * fixedInstant – the instant to use as the clock, not null
     * zone – the time-zone to use to convert the instant to date-time, not null
     * Returns:
     * a clock that always returns the same instant, not null
     * @param localTime
     * @return
     */
    private Clock createFixedClock(LocalTime localTime) {

        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localTime.atDate(LocalDate.now()).atZone(zoneId).toInstant();
        return Clock.fixed(instant, zoneId);
    }

    @Test
    public void instantTest() {

        System.out.println("new Date(): " + new Date());
        System.out.println("============Local===============");
        // 本地时间
        System.out.println("LocalDateTime.now(): " + LocalDateTime.now());
        // 指定日期时间
        LocalDateTime ldt1 = LocalDateTime.of(2021, Month.JANUARY, 2, 17, 23, 52);
        System.out.println("LocalDateTime.of: " + ldt1);
        LocalDate localDate = LocalDate.of(2021, Month.JANUARY, 2);
        LocalTime localTime = LocalTime.of(17, 23, 59);
        LocalDateTime ldt2 = localDate.atTime(localTime);
        System.out.println("localDate.atTime(localTime): " + ldt2);
        // 获取具体哪一年、月、天……
        System.out.println("getDayOfMonth(): " + ldt2.getDayOfMonth());
        System.out.println("=============Instant========================");
        // currentTimeMillis
        System.out.println("System.currentTimeMillis(): " + System.currentTimeMillis());
        // 时间戳类型，UTC当前时间
        System.out.println("Instant.now(): " + Instant.now());
        // 时间戳类型，毫秒表示
        System.out.println("Instant.now().toEpochMilli(): " + Instant.now().toEpochMilli());
        // 指定时区的时间点相距1970-01-01零时的时间戳
        // toInstant： The calculation combines the local date-time and offset.
        System.out.println("LocalDateTime.now() with systemDefaultZone to toEpochMilli: " + LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        // 表示从1970-01-01 00:00:00开始后两分钟的10万纳秒的时刻
        System.out.println("Instant.ofEpochSecond(120, 100000): " + Instant.ofEpochSecond(120, 100000));
        System.out.println("=============Duration=============");
        System.out.println("Duration.between: " + Duration.between(ldt1, ldt2).toSeconds());
        System.out.println("Duration.of Days: " + Duration.of(5, ChronoUnit.DAYS).toDays());
        System.out.println("Duration.of MILLIS: " + Duration.of(1000, ChronoUnit.MILLIS).toMillis());
        System.out.println("=============Period================");
        System.out.println("Period.of(): " + Period.of(2, 3, 6).getDays());
        System.out.println("Period.between():" + Period.between(LocalDate.of(2021, 1, 4), LocalDate.of(2021, 1, 5)).getDays());
        // 增加和减少日期
        System.out.println("==========================增加和减少日期===========================================");
        System.out.println("TemporalAdjusters.nextOrSame: " + LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)));
        System.out.println("TemporalAdjusters.lastInMonth: " + LocalDate.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.SATURDAY)));
        // 格式化日期
        System.out.println("==========================格式化日期===========================================");
        System.out.println("format DateTimeFormatter.ISO_DATE_TIME: " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("format DateTimeFormatter.ofPattern: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("parse DateTimeFormatter.ofPattern: " + LocalDateTime.parse("2021-01-04 17:39:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        // 时区
        System.out.println("==========================时区ZoneId===========================================");
        System.out.println("ZoneId.getAvailableZoneIds()" + ZoneId.getAvailableZoneIds());
        System.out.println("ZoneId.systemDefault()： " + ZoneId.systemDefault());
        System.out.println("ZoneId.of(\"Asia/Shanghai\"): " + ZoneId.of("Asia/Shanghai"));
        System.out.println("========================时区ZonedDateTime, OffsetDateTime===================================");
        System.out.println("ZonedDateTime.of() Shanghai, " + ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Shanghai")));
        System.out.println("ZonedDateTime.of() America, " + ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Cuiaba")));
        System.out.println("OffsetDateTime.of(), -4" + OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("-04:00")));
        System.out.println("OffsetDateTime.of(), UTC" + OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.UTC));
        System.out.println("=======================Clock==================================================");
        System.out.println("System.currentTimeMillis(): " + System.currentTimeMillis());
        System.out.println("Clock.systemDefaultZone(): " + Clock.systemDefaultZone());
        System.out.println("Clock.systemUTC(): " + Clock.systemUTC());
        System.out.println("Clock systemDefaultZone millis: " + Clock.systemDefaultZone().millis());
        System.out.println("Clock systemUTC millis: " + Clock.systemUTC().millis());
        System.out.println("Clock systemDefaultZone instant: " + Clock.systemDefaultZone().instant());
        System.out.println("Clock systemUTC instant: " + Clock.systemUTC().instant());
        System.out.println("LocalDateTime.now with Clock.systemDefaultZone()" + LocalDateTime.now(Clock.systemDefaultZone()));
        System.out.println("LocalDateTime.now with Clock.systemUTC()" + LocalDateTime.now(Clock.systemUTC()));
        System.out.println("LocalDateTime.now with zoneId default: " + LocalDateTime.now(ZoneId.systemDefault()));
        System.out.println("LocalDateTime.now with zoneId of: " + LocalDateTime.now(ZoneId.of("America/Cuiaba")));
    }
}