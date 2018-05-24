package com.torres.sort.search;


import com.torres.sort.HeapSort;

/**
 * 二分查找
 * Created by Torres
 * 2018-05-12 18:22
 */
public class BinarySearch {

    /**
     * 递归方式
     *
     * @param elem
     * @param array
     * @param low
     * @param high
     * @return
     */
    public int binarySearch(int elem, int[] array, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (array[middle] == elem) {
            System.out.println();
            System.out.println("找到对应元素为：" + array[middle] + " 下标为：" + middle);
            return middle;
        }
        if (array[middle] < elem) {
//            找右边
            return binarySearch(elem, array, middle + 1, high);
        }
        if (array[middle] > elem) {
//            找左边
            return binarySearch(elem, array, low, middle - 1);
        }
        return -1;
    }

    /**
     * 非递归
     *
     * @param array
     * @param elem
     * @return
     */
    public int directbinarySearch(int[] array, int elem) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (elem > array[middle]) {
//                右边找
                low = middle + 1;
            } else if (elem < array[middle]) {
                high = middle - 1;
            } else {
                System.out.println();
                System.out.println("找到对应元素为：" + array[middle] + " 下标为：" + middle);
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {10, 23, 4, 3, 2, 5, 1, 2, 623, 92, 23, 23, 234, 2, 34, 234, 234, 2, 10};
        new HeapSort().heapSort(array);
        //        new BasicSort().sort(array);
        for (int n : array) {
            System.out.print(" " + n);
        }
//        new BinarySearch().binarySearch(5, array, 0, array.length - 1);
        new BinarySearch().directbinarySearch(array, 2);
//        重复数字看最后元素，下标也是固定的
    }
}
