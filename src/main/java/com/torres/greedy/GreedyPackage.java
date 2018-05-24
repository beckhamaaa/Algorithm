package com.torres.greedy;

import java.util.Arrays;

/**
 * 贪心法：背包算法
 * Created by Torres
 * 2018-05-13 8:02
 */
public class GreedyPackage {
    private int MAX_WEIGHT = 150;
    private int[] weights = new int[]{35, 30, 60, 50, 40, 10, 25};
    private int[] values = new int[]{10,40, 30, 50, 35, 40, 30};

    /**
     * @param capacity
     * @param weights
     * @param values
     */
    public void packageGreedy(int capacity, int weights[], int[] values) {
        int n = weights.length;
//        性价比数组
        double[] r = new double[n];
//        性价比排序物品的下标
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = (double) values[i] / (double) weights[i];
//            默认排序
            index[i] = i;
        }
//        对性价比进行排序
        double temp = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (r[i] < r[j]) {
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                    int x = index[i];
                    index[i] = index[j];
                    index[j] = x;
                }
            }
        }
//          排序好的重量和价值分别存到数组
        int[] w1 = new int[n];
        int[] v1 = new int[n];
        for (int i = 0; i < n; i++) {
            w1[i] = weights[index[i]];
            v1[i] = values[index[i]];
        }
        int[] x = new int[n];
        int weight=0;
        int maxValue=0;
        for (int i = 0; i < n; i++) {
            if (w1[i] <= capacity) {
//                还可能装得下
//                表示该物品被装了
                x[i] = 1;
                weight+=w1[i];
                maxValue+=v1[i];
                System.out.println("物品"+w1[i]+"被放进包包");
                capacity = capacity - w1[i];
            }
        }
        System.out.println("总共放下的物品数量：" + Arrays.toString(x));
        System.out.println("装入的总重量为：" + weight);
        System.out.println("最大价值：" + maxValue);
    }

    public static void main(String[] args) {
        GreedyPackage greedyPackage=new GreedyPackage();
        greedyPackage.packageGreedy(greedyPackage.MAX_WEIGHT,greedyPackage.weights,greedyPackage.values);
    }
}
