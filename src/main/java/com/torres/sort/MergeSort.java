package com.torres.sort;

/**
 * 归并排序
 * Created by Torres
 * 2018-05-12 15:03
 */
public class MergeSort {

    public void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(a, left, middle);
            mergeSort(a, middle + 1, right);
//            合并
            merge(a, left, middle, right);
        }
    }

    private void merge(int[] a, int left, int middle, int right) {
        int[] tempArray = new int[a.length];
        int rightStart = middle + 1;
        int temp = left;
        int third = left;
//        比较两个小数相应下标位置的数组大小，小的先放进新数组
        while (left <= middle && rightStart <= right) {
            if (a[left] <= a[rightStart]) {
                tempArray[third++] = a[left++];
            } else {
                tempArray[third++] = a[rightStart++];
            }
        }
//        如果左边还有数据需要拷贝左边数组剩下的拷贝到新数组
        while (left <= middle) {
            tempArray[third++] = a[left++];
        }
//        如果右边还有数据需要拷贝右边数组剩下的拷贝到新数组
        while (rightStart <= right) {
            tempArray[third++] = a[rightStart++];
        }
        while (temp<=right){
            a[temp]=tempArray[temp++];
        }
    }

    public static void main(String[] args) {
        int [] a=new int[]{90,3,2,67,44,-9,87,65,11,9,2,8};
        new MergeSort().mergeSort(a,0,a.length-1);
        for (int n:a){
            System.out.print(" "+n);
        }
    }
}
