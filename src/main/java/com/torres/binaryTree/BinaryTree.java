package com.torres.binaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Torres
 * 2018-05-03 22:57
 */
public class BinaryTree {
    private TreeNode root = null;

    public BinaryTree() {
        root = new TreeNode(1, "A");
    }

    /**
     * 构建二叉树
     * A
     * B         C
     * D      E            F
     */
    public void createBinaryTree(String[] nodes) {
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.rightChild = nodeF;


    }

    /**
     * 求二叉树的高度
     *
     * @return
     */
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int i = getHeight(node.leftChild);
            int j = getHeight(node.rightChild);
            return (i < j) ? j + 1 : i + 1;
        }


    }

    /**
     * 获取二叉树的结点数
     *
     * @return
     */
    public int getSize() {

        return getSize(root);
    }

    private int getSize(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSize(node.leftChild) + getSize(node.rightChild);

        }
    }


    /**
     * 通过前序遍历的数据序列反向生成二叉树
     * A
     * B           C
     * D         E    #       F
     * #    #   #       #   #       #
     * A B D E C F
     * ABD##E##C#F##
     */
    public void createBinaryByTreePre(ArrayList<String> data) {
        createBinaryByTree(data.size(), data);
    }

    private TreeNode createBinaryByTree(int size, ArrayList<String> data) {
        if (data.size() == 0) {
            return null;
        }
        String d = data.get(0);
        TreeNode node;
        int index = size - data.size();
        if (d.equals("#")) {
            node = null;
            data.remove(0);
            return node;
        }
        node = new TreeNode(index, d);
        if (index == 0) {
            //创建根结点
            root = node;
        }
//        不移除根结点，内存溢出
            data.remove(0);
            node.leftChild = createBinaryByTree(size, data);
            node.rightChild = createBinaryByTree(size, data);

        return node;
    }





    /**
     * 前序遍历-迭代
     *
     * @param node
     */
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            System.out.println("preOrder data: " + node.getData());
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }

    }

    /**
     * 前序遍历-非迭代(利用栈)
     */
    public void nonRecOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while (!stack.isEmpty()) {
            //出栈和进栈
            TreeNode n = stack.pop();//弹出根结点
            //压入子结点，先压右结点
            System.out.println("nonRecOrder data:" + n.getData());
            if (n.rightChild != null) {
                stack.push(n.rightChild);
            }
            if (n.leftChild != null) {
                stack.push(n.leftChild);
            }
        }
    }

    /**
     * 中序遍历-迭代
     *
     * @param node
     */
    public void midOrder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            midOrder(node.leftChild);
            System.out.println("midOrder data: " + node.getData());
            midOrder(node.rightChild);
        }
    }

    /**
     * 后序遍历-迭代
     *
     * @param node
     */
    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println("postOrder data: " + node.getData());
        }
    }


    public class TreeNode {
        private int index;
        private String data;
        private TreeNode leftChild;
        private TreeNode rightChild;
        private TreeNode parent;

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public TreeNode(int index, String data) {
            this.index = index;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;

        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree(null);
        int height = binaryTree.getHeight();
        System.out.println("treeHeight " + height);
        int size = binaryTree.getSize();
        System.out.println("treeSize " + size);
        binaryTree.preOrder(binaryTree.root);
        binaryTree.midOrder(binaryTree.root);
        binaryTree.postOrder(binaryTree.root);
        binaryTree.nonRecOrder(binaryTree.root);
        ArrayList<String> data=new ArrayList<String>();
        String[] dataArray=new String[]{"A","B","D","#","#","E","#","#","C","#","F","#","#"};
        for (String d: dataArray) {
         data.add(d);
        }
        binaryTree.createBinaryByTreePre(data);
        binaryTree.preOrder(binaryTree.root);
    }

    /**
     * 考试成绩分级
     * 100 5    15  30  40 10
     *     60   70  80  90
     * @param score
     * @return
     */
    public String getScore(int score){
        if(score<60){
            return "不及格";
        }else if(score<70){
            return "及格";
        }else {
            return "优秀";
        }
    }


}
