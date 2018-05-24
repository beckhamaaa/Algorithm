package com.torres.recursion;

/**
 * 汉诺塔
 * Created by Torres
 * 2018-05-12 19:07
 */
public class HanNota {
    private int i=1;
    public void hanNota(int n, char from, char dependOn, char to) {
        if (n == 1) {
            move(1, from, to);
        } else {
//            第一步：先将n-1个盘子从A利用C挪到B
            hanNota(n - 1, from, to, dependOn);
//            将n个盘子(底盘)从A挪到C
            move(n,from,to);
//            将n-1个盘子从B挪到以C
            hanNota(n-1,dependOn,from,to);
        }
    }

    private void move(int n, char from, char to) {
        System.out.println("第" + i +++ "步从" + from + "----->" + to);

    }

    public static void main(String[] args) {
        new HanNota().hanNota(4,'A','B','C');
    }
}
