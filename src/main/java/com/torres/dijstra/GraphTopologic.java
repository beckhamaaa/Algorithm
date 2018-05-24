package com.torres.dijstra;

import java.util.Stack;

/**
 * 拓扑排序
 * Created by Torres
 * 2018-05-07 23:01
 */
public class GraphTopologic {
    //    邻接顶点的一维数组
    private VertexNode[] adjList;
    private int numVertexes;

    public GraphTopologic(int numVertexes) {
        this.numVertexes = numVertexes;

    }

    private void createGraph() {
        VertexNode node0 = new VertexNode(0, "v0");
        VertexNode node1 = new VertexNode(0, "v1");
        VertexNode node2 = new VertexNode(2, "v2");
        VertexNode node3 = new VertexNode(0, "v3");
        VertexNode node4 = new VertexNode(2, "v4");
        VertexNode node5 = new VertexNode(3, "v5");
        VertexNode node6 = new VertexNode(1, "v6");
        VertexNode node7 = new VertexNode(2, "v7");
        VertexNode node8 = new VertexNode(2, "v8");
        VertexNode node9 = new VertexNode(1, "v9");
        VertexNode node10 = new VertexNode(1, "v10");
        VertexNode node11 = new VertexNode(2, "v11");
        VertexNode node12 = new VertexNode(1, "v12");
        VertexNode node13 = new VertexNode(2, "v13");
        adjList = new VertexNode[numVertexes];
        adjList[0] = node0;
        adjList[1] = node1;
        adjList[2] = node2;
        adjList[3] = node3;
        adjList[4] = node4;
        adjList[5] = node5;
        adjList[6] = node6;
        adjList[7] = node7;
        adjList[8] = node8;
        adjList[9] = node9;
        adjList[10] = node10;
        adjList[11] = node11;
        adjList[12] = node12;
        adjList[13] = node13;
        node0.firstEdge = new EdgeNode(11);
        node0.firstEdge.next = new EdgeNode(5);
        node0.firstEdge.next.next = new EdgeNode(4);
        node1.firstEdge = new EdgeNode(8);
        node1.firstEdge.next = new EdgeNode(4);
        node1.firstEdge.next.next = new EdgeNode(2);
        node2.firstEdge = new EdgeNode(9);
        node2.firstEdge.next = new EdgeNode(6);
        node2.firstEdge.next.next = new EdgeNode(5);
        node3.firstEdge = new EdgeNode(13);
        node3.firstEdge.next = new EdgeNode(2);
        node4.firstEdge = new EdgeNode(7);
        node5.firstEdge = new EdgeNode(12);
        node5.firstEdge.next = new EdgeNode(8);
        node6.firstEdge = new EdgeNode(5);
        node8.firstEdge = new EdgeNode(7);
        node9.firstEdge = new EdgeNode(11);
        node9.firstEdge.next = new EdgeNode(10);
        node10.firstEdge = new EdgeNode(13);
        node12.firstEdge = new EdgeNode(9);
    }

    /**
     * 拓扑排序
     */
    private void topologicalSort() throws Exception {
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        int k = 0;
        for (int i = 0; i < numVertexes; i++) {
            if (adjList[i].in == 0) {
//                入栈
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
//                出栈
            int pop = stack.pop();
            System.out.println("顶点："+adjList[pop].data);
            count++;
            for (EdgeNode node=adjList[pop].firstEdge;node!=null;node=node.next) {
//              下标
                k=node.adjVert;
                if(--adjList[k].in==0){
//                    入度为0，入栈
                    stack.push(k);

                }

            }
        }
        if(count<numVertexes){
            throw new Exception("拓扑排序失败");
        }
        System.out.println("顶点数："+count);
    }

    /**
     * 边表顶点
     */
    class EdgeNode {
        private int adjVert;
        private EdgeNode next;
        //        权重
        private int weight;

        public EdgeNode(int adjVert) {
            this.adjVert = adjVert;
        }

        public int getAdjVert() {
            return adjVert;
        }

        public void setAdjVert(int adjVert) {
            this.adjVert = adjVert;
        }

        public EdgeNode getNext() {
            return next;
        }

        public void setNext(EdgeNode next) {
            this.next = next;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    /**
     * 邻接顶点
     */
    class VertexNode {
        //        入度
        private int in;
        private String data;
        private EdgeNode firstEdge;


        public VertexNode(int in, String data) {
            this.in = in;
            this.data = data;
        }

        public int getIn() {
            return in;
        }

        public void setIn(int in) {
            this.in = in;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public EdgeNode getFirstEdge() {
            return firstEdge;
        }

        public void setFirstEdge(EdgeNode firstEdge) {
            this.firstEdge = firstEdge;
        }
    }

    public static void main(String[] args) {
        GraphTopologic graphTopologic = new GraphTopologic(14);
        graphTopologic.createGraph();
        try {
            graphTopologic.topologicalSort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
