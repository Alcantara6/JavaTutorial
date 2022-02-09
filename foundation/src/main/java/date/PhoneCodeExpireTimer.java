package date;

import java.time.*;

/**
 * @author yanjing
 * @date 2021/10/28
 */
public class PhoneCodeExpireTimer {
    
    private Clock clock;
    
    private int codeExpireSeconds = 120;

    public PhoneCodeExpireTimer() {
        this.clock = Clock.systemDefaultZone();
    }

    public PhoneCodeExpireTimer(int codeExpireSeconds) {
        
        this.clock = Clock.systemDefaultZone();
        this.codeExpireSeconds = codeExpireSeconds;
    }

    public PhoneCodeExpireTimer(Clock clock) {
        this.clock = clock;
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public int getCodeExpireSeconds() {
        return codeExpireSeconds;
    }

    public void setCodeExpireSeconds(int codeExpireSeconds) {
        this.codeExpireSeconds = codeExpireSeconds;
    }

    public int countExpireTime() {

        return (int) Duration.between(LocalDateTime.now(clock), maxLocalDateTime()).toSeconds();
    }

    private LocalDateTime maxLocalDateTime() {

        return LocalDateTime.of(LocalDate.now(clock), LocalTime.MAX);
    }
}
