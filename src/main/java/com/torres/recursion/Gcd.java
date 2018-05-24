package com.torres.recursion;

/**
 * 欧几里德算法
 * Created by Torres
 * 2018-05-12 19:58
 */
public class Gcd {
    //    (m>n) m和n的最大公约数为n和m%n的最大公约数
//36 24 12  24 36%24=12
    public int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }

    public static void main(String[] args) {
        int x = new Gcd().gcd(99, 55);
        System.out.println("x=" + x);
    }

}
