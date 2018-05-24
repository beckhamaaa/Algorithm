package com.torres.recursion;

/**
 * 计算n的阶乘
 * Created by Torres
 * 2018-05-12 20:23
 */
public class CalNFact {
    public int f(int n) {
        if (n == 1) {
            return n;
        } else {
            return n * f(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(n + "的阶乘为：" + new CalNFact().f(n));
    }
}
