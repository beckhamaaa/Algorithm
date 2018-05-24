package com.torres.sort;

/**
 * 直接插入排序
 * Created by Torres
 * 2018-05-12 9:14
 */
public class InsertSort {


    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1};
        for (int i = 1; i < a.length; i++) {
            //新遍历的值，等待插入到前面的有序数组
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
//                将大于temp的数往后面移一步
                if (a[j] > temp) {
                    a[j + 1] = a[j];

                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }
        System.out.println("排序后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }


}
