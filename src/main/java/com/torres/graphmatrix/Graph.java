package com.torres.graphmatrix;

import java.util.LinkedList;

/**
 * 图
 * Created by Torres
 * 2018-05-06 16:55
 */
public class Graph {
    //    顶点数量
    private int vertexSize;
    //顶点数组
    private int[] vertexs;
    private int[][] matrix;
    private static final int MAX_WEIGHT = 1000;
    private boolean[] isVisited;

    public Graph(int vertexSize) {
        this.vertexSize = vertexSize;
        matrix = new int[vertexSize][vertexSize];
        vertexs = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            vertexs[i] = i;
        }
        isVisited = new boolean[vertexSize];
    }

    public int[] getVertexs() {
        return vertexs;
    }

    public void setVertexs(int[] vertexs) {
        this.vertexs = vertexs;
    }




    /**
     * 获取某个顶点的出度
     */
    public int getOutDegree(int index) {
        int degree = 0;
        for (int j = 0; j < matrix[index].length; j++) {
            int weight = matrix[index][j];
            if (weight != 0 && weight != MAX_WEIGHT) {
                degree++;
            }
        }
        return degree;
    }


    /**
     * 获取某个结点的入度
     *
     * @return
     */
    public int getInDegree() {

        return 0;
    }


    /**
     * 获取两个顶点这间的权值
     *
     * @return
     */
    public int getWeight(int v1, int v2) {
        int weight = matrix[v1][v2];
        return weight == 0 ? 0 : (weight == MAX_WEIGHT ? -1 : weight);

    }

    /**
     * 获取某个顶点的第一个邻接点
     *
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexSize; j++) {
            if (matrix[index][j] > 0 && matrix[index][j] < MAX_WEIGHT) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 获取前一个邻接点的下标来取得下一个邻接点
     *
     * @param v     表示要找的顶点
     * @param index 表示该顶点相对于哪个邻接点去获取下一个邻接点
     * @return
     */
    public int getNextNeighbor(int v, int index) {
        for (int j = index + 1; j < vertexSize; j++) {
            if (matrix[v][j] > 0 && matrix[v][j] < MAX_WEIGHT) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 图的深度优先遍历算法
     *
     * @param i
     */
    public void depthFirstSearch(int i) {
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
//           需要遍历该顶点
                System.out.println("访问到了： " + w + "顶点");
                depthFirstSearch(w);
            }
//            第一个相对于w的邻接结点
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 对外公开的深度优先遍历
     */
    public void depthFirstSearch() {
        isVisited = new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            if (!isVisited[i]) {
                System.out.println("访问到了：" + i + "顶点");
                depthFirstSearch(i);
            }
        }
        isVisited = new boolean[vertexSize];
    }

    /**
     * 普里姆算法
     */
    public void prim() {
//    最小代价顶点权值的数组，为0表示已经获取最小权值
        int[] lowcost = new int[vertexSize];
//        放顶点权值
        int[] adjvex = new int[vertexSize];
        int min, minId, sum = 0;
        for (int i = 1; i < vertexSize; i++) {
            lowcost[i] = matrix[0][i];
        }
        for (int i = 1; i < vertexSize; i++) {
            min = MAX_WEIGHT;
            minId = 0;
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] < min && lowcost[j] > 0) {
                    min = lowcost[j];
                    minId = j;
                }
            }
            System.out.println("顶点：" + adjvex[minId] + "权值：" + min);
            sum += min;
            lowcost[minId] = 0;
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] != 0 && matrix[minId][j] < lowcost[j]) {
                    lowcost[j] = matrix[minId][j];
                    adjvex[j] = minId;
                }
            }
        }
        System.out.println("最小生成树权值和："+sum);
    }

    /**
     * 图的广度优先搜索算法
     */
    public void broadFirstSearch() {
        isVisited = new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            if (!isVisited[i]) {
                broadFirstSearch(i);
            }
        }
    }

    /**
     * 实现广度优先遍历
     *
     * @param i
     */
    private void broadFirstSearch(int i) {
        int u, w;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        System.out.println("访问到： " + i + "顶点");
        isVisited[i] = true;
//        第一次把v0加到队列
        queue.add(i);
        while (!queue.isEmpty()) {
            u = (Integer) (queue.removeFirst()).intValue();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.println("访问到了： " + w + "顶点");
                    isVisited[w] = true;
                    queue.add(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        int[] a1 = new int[]{0, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 6};
        int[] a2 = new int[]{9, 0, 3, MAX_WEIGHT, MAX_WEIGHT};
        int[] a3 = new int[]{2, MAX_WEIGHT, 0, 5, MAX_WEIGHT};
        int[] a4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0, 1};
        int[] a5 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};
        graph.matrix[0] = a1;
        graph.matrix[1] = a2;
        graph.matrix[2] = a3;
        graph.matrix[3] = a4;
        graph.matrix[4] = a5;
        int degree = graph.getOutDegree(0);
        System.out.println("v0的出度：" + degree);
        System.out.println("权值：" + graph.getWeight(2, 3));

        Graph graph1 = new Graph(9);
        int[] b1 = new int[]{0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] b2 = new int[]{10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12};
        int[] b3 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8};
        int[] b4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, MAX_WEIGHT, 16, 21};
        int[] b5 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT};
        int[] b6 = new int[]{11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT};
        int[] b7 = new int[]{MAX_WEIGHT, 16, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT};
        int[] b8 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT};
        int[] b9 = new int[]{MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};

        graph1.matrix[0] = b1;
        graph1.matrix[1] = b2;
        graph1.matrix[2] = b3;
        graph1.matrix[3] = b4;
        graph1.matrix[4] = b5;
        graph1.matrix[5] = b6;
        graph1.matrix[6] = b7;
        graph1.matrix[7] = b8;
        graph1.matrix[8] = b9;

        graph1.depthFirstSearch();
        graph1.broadFirstSearch();
        graph1.prim();
    }
}
