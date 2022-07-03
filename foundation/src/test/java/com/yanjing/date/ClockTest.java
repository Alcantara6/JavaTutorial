package com.yanjing.date;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author yanjing
 * @date 2021/11/2
 */
class ClockTest {

    /**
     * 构造单元测试
     */
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

        System.out.println("=============Instant========================");
        // currentTimeMillis
        System.out.println("System.currentTimeMillis(): " + System.currentTimeMillis());

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