package com.yanjing.wraptype;

import java.util.Date;

/**
 * @author yanjing
 * @date 2023/3/19
 */
public class TestString {

    /**
     * %[argument number] [flag] [width] [.precision] type
     */
    public static void main(String[] args) {;
;
        System.out.println(String.format("%, d", 1000000000));
        System.out.println(String.format("I have %.2f bugs to fix", 476578.09876));
        System.out.println(String.format("I have %,.2f bugs to fix", 476578.09876));
        // 参数必须是byte, short, int, long, BigIneger
        System.out.println(String.format("%x", 42)); // 2a
        // 参数必须是byte, short, int, long
        System.out.println(String.format("%c", 42)); // *，ASCⅡ的42代表“*”

        // 多个参数
        System.out.println(String.format("The rank is %,d out of %,.2f", 20456654, 100567890.248907));

        // 日期，type用“t”开头的两个字符表示
        Date date = new Date();
        // 完整的日期与时间
        System.out.println(String.format("%tc", date));
        // 只有时间
        System.out.println(String.format("%tr", date));
        // 星期，月，日 %tA, %tB, %td
        System.out.println(String.format("%tA, %tB, %td", date, date, date));
        // <符号重复利用
        System.out.println(String.format("%tA, %<tB, %<td", date));
    }
}
