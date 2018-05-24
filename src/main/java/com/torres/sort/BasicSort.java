package com.torres.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序,question
 * Created by Torres
 * 2018-05-12 17:11
 */
public class BasicSort {

    public void sort(int[] array) {
//        获取最大值
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int times = 0;
        while (max > 0) {
            max = max / 10;
            times++;
        }
//        多维数组
        List<ArrayList> queue = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            ArrayList q = new ArrayList();
            queue.add(q);
        }
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < array.length; j++) {
//                获取对位位的值 (i=0 个位，i=1 十位，i=2 百位)
                int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList q = queue.get(x);
//                把元素添加进对应下标数组
                q.add(array[j]);
//               queue.set(x, q);
            }
        }
        //开始收集
        int count = 0;
        for (int j = 0; j < 10; j++) {
            while (queue.get(j).size() > 0&&count<array.length) {
//            拿到每一个数组
                ArrayList<Integer> q = queue.get(j);
                array[count] = q.get(0);
                q.remove(0);
                count++;

            }

        }
    }

    public static void main(String[] args) {
        int [] a = {136,2,6,8,9,2,8,11,23,56,34,90,89,29,145,209,320,78,3};
        new BasicSort().sort(a);
        for (int n:a) {
            System.out.print(" "+n);
        }
    }
}
