package com.torres.sort;

/**
 * 希尔排序
 * Created by Torres
 * 2018-05-12 10:16
 */
public class HeerSort {
    public static void main(String[] args) {
        int[] a = {49, 38, 44, 2, 0, 7, 3, 8, 20, 14, 88, 56, -8, -33, 28, 1, -9, 7, 2, 5, 23, 12, 99, 76};
//        默认增量是8
        int d = a.length / 2;
        while (true) {
            for (int i = 0; i < d; i++) {
                for (int j = i; j + d < a.length; j += d) {
                        int temp;
                        if (a[j] > a[j + d]) {
                            temp = a[j];
                            a[j] = a[j + d];
                            a[j + d] = temp;
                        }
                }
            }
            if (d == 1) {
                break;
            }
            d--;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }
}
