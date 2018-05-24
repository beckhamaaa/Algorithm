package com.torres.sort;

/**
 * 二分法插入排序
 * Created by Torres
 * 2018-05-12 9:39
 */
public class BinaryInsertSort {

    private void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            //待插入到前面有序序列的值
            int temp = a[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
//                比left右边大的值往后移一们，等待temp插入
                a[j + 1] = a[j];

            }
            if (left != i) {
                a[left] = temp;
            }
        }
        for (int i = 0; i <a.length ; i++) {
            System.out.print(" "+a[i]);
        }
    }

    public static void main(String[] args) {
        int [] a={10,8,11,3,4,6,7,11,2,90,18,33,28,-1,0,7};
        new BinaryInsertSort().sort(a);
    }

}
