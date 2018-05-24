package com.torres.sort;

/**
 * 快速排序
 * Created by Torres
 * 2018-05-12 14:29
 */
public class QuickSort {
    public void quick(int[] a) {
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
    }

    /**
     * 快速排序
     *
     * @param a
     * @param low
     * @param high
     */
    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int middle = getMiddle(a, low, high);
            quickSort(a,0,middle-1);
            quickSort(a,middle+1,high);
        }
    }

    /**
     * 获取中间下标
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    private int getMiddle(int[] a, int low, int high) {
//        基准元素
        int temp = a[low];
        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
//        插入到排序后正确的位置
        a[low] = temp;
        return low;
    }

    public static void main(String[] args) {
        int [] a={19,2,3,90,67,33,-7,24,3,56,34,5};
        new QuickSort().quick(a);
        for(int num:a){
            System.out.print(" "+num);
        }
    }
}
