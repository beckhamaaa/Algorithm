package com.torres.sort;

/**
 * 简单选择排序
 * Created by Torres
 * 2018-05-12 8:41
 */
public class SelectSort {

    public void selectSort(int[] array) {
        int min;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            min = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    temp=array[i];
                    array[i] = min;
                    array[j]=temp;
                }
            }
        }
        for (int num : array) {
            System.out.print(" " + num);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 4, 2, 6, 7, 3, 10, 33, 88, 1, 17};
        new SelectSort().selectSort(array);

    }
}
