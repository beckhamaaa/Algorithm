package com.torres.josephus;

/**
 * 约瑟夫杀人法
 * Created by Torres
 * 2018-05-13 16:06
 */
public class Josephus {
    public static int N=20;
//    数到M就杀掉此人
    public static int M=5;

    class Node{
//        下标
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }
    }

    public void killNode(){
//        第一个结点
        Node header=new Node(1);
//        目前被点到人
        Node x=header;
        for (int i = 2; i <=N; i++) {
            x=(x.next=new Node(i));
        }
//        头尾相接
        x.next=header;
        System.out.println("被杀掉的顺序为：");
        while (x!=x.next){
//            至少还有两人，仍然继续报数，继续杀
            for (int i = 1; i <M; i++) {
                x=x.next;
            }
            System.out.println(x.next.val+"被干掉了");
            x.next=x.next.next;
        }
        System.out.println("最后这个幸运儿是："+x.val);
    }

    public static void main(String[] args) {
        new Josephus().killNode();
    }
}
