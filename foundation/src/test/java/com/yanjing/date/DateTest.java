package com.yanjing.date;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author yanjing
 * @date 2022/6/30
 */
public class DateTest {

    @Test
    public void date2StringTest() {
        Date date = new Date();
        // 标准的UTC时间
        System.out.println(date.toString());
        // 本地时间，根据本地时区显示的时间格式
        System.out.println(date.toLocaleString());
        // GTM时间
        System.out.println(date.toGMTString());
    }

    static class ZoneTest {

        @Test
        public void timeZoneFormatTest() {
            String patternStr = "yyyy-MM-dd HH:mm:ss";
            // 北京时间（new出来就是默认时区的时间）
            Date bjDate = new Date();

            // 得到纽约的时区
            TimeZone newYorkTimeZone = TimeZone.getTimeZone("America/New_York");
            // 根据此时区 将北京时间转换为纽约的Date
            DateFormat newYorkDateFormat = new SimpleDateFormat(patternStr);
            newYorkDateFormat.setTimeZone(newYorkTimeZone);
            System.out.println("这是北京时间：" + new SimpleDateFormat(patternStr).format(bjDate));
            System.out.println("这是纽约时间：" + newYorkDateFormat.format(bjDate));
        }

        @Test
        public void getAvailableZoneIDsTest() {
            String[] availableIDs = TimeZone.getAvailableIDs();
            System.out.println("可用zoneId总数：" + availableIDs.length);
            for (String zoneId : availableIDs) {
                System.out.println(zoneId);
            }
        }

        /**
         * 指定其时区数字表示形式，其实也叫偏移量
         */
        @Test
        public void getTimeZoneTest() {
            System.out.println(TimeZone.getTimeZone("GMT+08:00").getID());
            System.out.println(TimeZone.getDefault().getID());

            // 纽约时间
            System.out.println(TimeZone.getTimeZone("GMT-05:00").getID());
            System.out.println(TimeZone.getTimeZone("America/New_York").getID());
        }

        /**
         * Java让我们有多种方式可以手动设置/修改默认时区：
         * API方式：强制将时区设为北京时区TimeZone.setDefault(TimeZone.getDefault().getTimeZone("GMT+8"));
         * JVM参数方式：-Duser.timezone=GMT+8
         * 运维设置方式：将操作系统主机时区设置为北京时区，这是推荐方式，可以完全对开发者无感，也方便了运维统一管理
         *
         * 很多公司在阿里云、腾讯云、国内外的云主机上部署应用时，全部都是采用运维设置统一时区：中国时区，这种方式来管理的
         */
        @Test
        public void defaultZoneTest() {
            TimeZone.setDefault(TimeZone.getTimeZone("GMT+06:00"));
            System.out.println(new Date());
        }

        /**
         * Date时区无关性
         */
        @Test
        public void dateNoRelatedWithZoneTest() {
            String patternStr = "yyyy-MM-dd HH:mm:ss";
            Date currDate = new Date(System.currentTimeMillis());

            // 北京时区
            DateFormat bjDateFormat = new SimpleDateFormat(patternStr);
            bjDateFormat.setTimeZone(TimeZone.getDefault());

            // 纽约时区
            DateFormat newYorkDateFormat = new SimpleDateFormat(patternStr);
            newYorkDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));

            // 伦敦时区
            DateFormat londonDateFormat = new SimpleDateFormat(patternStr);
            londonDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));

            System.out.println("毫秒数:" + currDate.getTime() + ", 北京本地时间:" + bjDateFormat.format(currDate));
            System.out.println("毫秒数:" + currDate.getTime() + ", 纽约本地时间:" + newYorkDateFormat.format(currDate));
            System.out.println("毫秒数:" + currDate.getTime() + ", 伦敦本地时间:" + londonDateFormat.format(currDate));
        }
    }

    /**
     * 日期/时间模式
     * public SimpleDateFormat(String pattern, Locale locale);
     */
    @Test
    public void simpleDateFormatLocaleTest() throws ParseException {

        String patternStr = "G GG GGGGG E EE EEEEE a aa aaaaa";
        Date currDate = new Date();

        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓中文地区模式↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        System.out.println("====================Date->String====================");
        DateFormat dateFormat = new SimpleDateFormat(patternStr, Locale.CHINA);
        System.out.println(dateFormat.format(currDate));

        System.out.println("====================String->Date====================");
        String dateStrParam = "公元 公元 公元 星期六 星期六 星期六 下午 下午 下午";
        System.out.println(dateFormat.parse(dateStrParam));

        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓英文地区模式↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        System.out.println("====================Date->String====================");
        dateFormat = new SimpleDateFormat(patternStr, Locale.US);
        System.out.println(dateFormat.format(currDate));

        System.out.println("====================String->Date====================");
        // 若有多个part表示一个意思，那么last win。如Sat SatUrday sunDay最后一个生效
        dateStrParam = "AD bc ad Sat Saturday Sun PM PM Am";
        System.out.println(dateFormat.parse(dateStrParam));
    }
}
