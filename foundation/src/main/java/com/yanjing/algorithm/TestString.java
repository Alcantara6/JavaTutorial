package com.yanjing.algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yanjing
 * @date 2022/1/3
 */
public class TestString {

    private final static int MOD = 1000000007;

    public static void main(String[] args) {

        System.out.println("replaceBlank [ ab cd ]" + replaceBlank(" ab cd ", "%20"));
        System.out.println("replaceBlankAPI [ ab cd ]" + replaceBlankAPI(" ab cd ", "%20"));
        System.out.println("samePrefix {\"bbf\", \"abcd\", \"cbb\"}" + samePrefix(new String[]{"bbf", "abcd", "cbb"})); // 空串
        System.out.println("samePrefix {\"abf\", \"abcd\", \"abb\"}" + samePrefix(new String[]{"abf", "abcd", "abb"}));
        System.out.println("longestPalindrome of abcdabcz: " + longestPalindrome("abcdabcz"));
        System.out.println("isPalindrome of [ A b2d 2 ba  ]: " + isPalindrome(" a b2d 2 ba  "));
        System.out.println("isPalindrome of [ab2d22a]: " + isPalindrome("ab2d22a"));
        System.out.println("evalRPN: " + evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println("evalRPN: " + evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println("evalRPN: " + evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        System.out.println("countPrimes <=4: " + countPrimes(4));
        System.out.println("countPrimes <=6：" + countPrimes(6));
        System.out.println("fib 4：" + fib(4));
        System.out.println("fib2 4：" + fib2(4));
    }

    /**
     * 遍历字符去除空格
     * @param str
     * @param r
     * @return
     */
    public static String replaceBlank(String str, String r) {

        int len = str.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {

            char c = str.charAt(i);
            if (" ".equals(String.valueOf(c))) {

                sb.append(r);
            } else {

                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * API方式去除空格
     * @param str
     * @param r
     * @return
     */
    public static String replaceBlankAPI(String str, String r) {

        return str.replaceAll("\\s", r);
    }

    /**
     * 最长公共前缀，先利用Arrays.sort(strs)为数组排序，再将数组第一个元素和最后一个元素的字符从前往后对比
     * @param strs
     * @return
     */
    public static String samePrefix(String[] strs) {

        // 这里没有处理null和{}
        Arrays.sort(strs);
        int strsLen = strs.length;
        StringBuilder sb = new StringBuilder();
        int comparedNums = Math.min(strs[0].length(), strs[strsLen - 1].length());
        for (int i = 0; i < comparedNums; i++) {

            if (strs[0].charAt(i) == strs[strsLen - 1].charAt(i)) {

                sb.append(strs[0].charAt(i));
            } else {

                break;
            }
        }
        return sb.toString();
    }

    /**
     * 最长回文串：给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串的长度
     * HashSet找成对
     * @param str
     * @return
     */
    public static int longestPalindrome(String str) {

        if (str.length() == 0) {

            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();
        int count = 0;
        for (char aChar : chars) {

            if (set.contains(aChar)) {

                set.remove(aChar);
                count++;
            } else {

                set.add(aChar);
            }
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }

    /**
     * 验证回文串，从头和尾开始向中间遍历
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {

        if (str.length() == 0) {

            return false;
        }
        int index = 0;
        int lastIndex = str.length() - 1;
        while (index < lastIndex) {

            if (!Character.isLetterOrDigit(str.charAt(index))) {

                index++;
            } else if (!Character.isLetterOrDigit(str.charAt(lastIndex))) {

                lastIndex--;
            } else {

                if (Character.toLowerCase(str.charAt(index)) != Character.toLowerCase(str.charAt(lastIndex))) {

                    return false;
                }
                index++;
                lastIndex--;
            }
        }
        return true;
    }

    /**
     * 逆波兰表达式求值
     * @param tokens
     * @return
     * 如果遇到操作数，则将操作数入栈；
     * 如果遇到运算符，则将两个操作数出栈，其中先出栈的是右操作数，后出栈的是左操作数，使用运算符对两个操作数进行运算，将运算得到的新操作数入栈
     */
    public static int evalRPN(String[] tokens) {

        ArrayDeque<String> deque = new ArrayDeque<>();
        for (String token : tokens) {

            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {

                int second = Integer.valueOf(deque.pollLast());
                int first = Integer.valueOf(deque.pollLast());
                int result = canculate(first, second, token);
                deque.offerLast(String.valueOf(result));
            } else {
                deque.offerLast(token);
            }
        }
        return Integer.valueOf(deque.getLast());
    }

    private static int canculate(int first, int second, String operator) {

        switch (operator) {

            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                return 0;
        }
    }

    /**
     * 质数的个数，方法一：枚举，时间复杂度n的1.5次方
     * @param n
     * @return
     */
    public static int countPrimes(int n) {

        int count = 0;
        for (int i = 2; i < n; i++) {

            if (isPrime(i)) {

                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int number) {

        for (int i = 2; i * i <= number; i++) {

            if (number % i == 0) {

                return false;
            }
        }
        return true;
    }

    /**
     * 斐波那契数列，方法一，迭代，局部变量滚动
     * @param n
     * @return
     */
    public static int fib(int n) {

        if (n == 0) {

            return 0;
        }
        if (n == 1) {

            return 1;
        }
        int first = 0;
        int second = 1;
        int third = 0;
        for (int i = 2; i <= n; i++) {

            third = (first + second) % MOD;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 斐波那契数列，方法二，尾递归，参数中滚动
     * @param n
     * @return
     */
    public static int fib2(int n) {

        return fibImpl(0, 1, n);
    }

    private static int fibImpl(int a, int b, int n) {

        if (n <= 0) {

            return a;
        }
        return fibImpl(b, (a+b) % MOD, n - 1);
    }
}
