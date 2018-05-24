package com.torres.binaryTree;

/**
 * Created by Torres
 * 2018-05-05 21:02
 */
public class SearchBinayTree {
    public static void main(String[] args) {
        SearchBinayTree binayTree = new SearchBinayTree();
        int[] intArray = new int[]{50, 30, 20, 44, 88, 33, 87, 16, 7, 77};
        for (int i : intArray) {
            binayTree.put(i);
        }
        binayTree.midOrder(binayTree.root);
        try {
            binayTree.deleteNode(44);
            binayTree.midOrder(binayTree.root);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private TreeNode root;

    public SearchBinayTree() {
    }

    /**
     * 中序遍历
     *
     * @param node
     * @return
     */
    public void midOrder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            midOrder(node.leftChild);
            System.out.println(node.data);
            midOrder(node.rightChild);
        }
    }

    /**
     * 构建查找二叉树,添加结点
     *
     * @return
     */
    public TreeNode put(int data) {
        TreeNode node = null;
        TreeNode parent = null;
        if (root == null) {
            node = new TreeNode(0, data);
            root = node;
            return node;
        }
        node = root;
        while (node != null) {
            parent = node;
            if (data > node.data) {
                node = node.rightChild;
            } else if (data < node.data) {
                node = node.leftChild;
            } else {
                return node;
            }
        }
//    表示将此结点添加到相应位置
        node = new TreeNode(0, data);
        if (data < parent.data) {
            parent.leftChild = node;
        } else {
            parent.rightChild = node;
        }
        node.parent = parent;
        return node;

    }

    /**
     * 删除结点
     *
     * @param key
     */
    public void deleteNode(int key) throws Exception {
        TreeNode node = searchNode(key);
        if (node == null) {
            throw new Exception("该结点无法找到");
        } else {
//            删除该结点
            delete(node);
        }
    }

    private void delete(TreeNode node) throws Exception {
        System.out.println(node);
        if (node == null) {
            throw new Exception("该结点无法找到");
        } else {
            TreeNode parent = node.parent;
//            被删除的结点无左右孩子
            if (node.leftChild == null && node.rightChild == null) {
                if (parent.leftChild == node) {
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                }
            }
//            被删除结点有左无右
            if (node.leftChild != null && node.rightChild == null) {
                if (parent.leftChild == node) {
                    parent.leftChild = node.leftChild;
                } else {
                    parent.rightChild = node.leftChild;
                }
                return;

            }
//            被删除结点有右无左
            if (node.leftChild == null && node.rightChild != null) {
                if (parent.leftChild == node) {
                    parent.leftChild = node.rightChild;
                } else {
                    parent.rightChild = node.rightChild;
                }
                return;
            }
//            左右孩子都有
//            找到该结点后继结点
            TreeNode next = getNextNode(node);
            delete(next);
            node.data = next.data;
        }

    }

    /**
     * 获取一个结点的后继结点
     * @param node
     * @return
     */
    private TreeNode getNextNode(TreeNode node) {
        if (node == null) {
            return null;
        } else {
            if (node.rightChild != null) {
//                     找某结点最小关键字结点
                return getMinTreeNode(node.rightChild);
            }else {
                TreeNode parent=node.parent;
                while (parent!=null&&node==parent.rightChild){
                    node=parent;
                    parent=parent.parent;

                }
                return parent;

            }
        }

    }

    private TreeNode getMinTreeNode(TreeNode node) {
        if (node == null) {
            return null;
        } else {
            while (node != null) {
                node = node.leftChild;
            }
        }

        return node;
    }

    private TreeNode searchNode(int key) {
        TreeNode node = root;
        if (node == null) {
            return null;
        } else {
            while (node != null && key != node.data) {
                if (key < node.data) {
                    node = node.leftChild;
                } else {
                    node = node.rightChild;
                }
            }
        }
        return node;
    }


    class TreeNode {
        private int key;
        private TreeNode leftChild;
        private TreeNode rightChild;
        private TreeNode parent;
        private int data;

        public TreeNode(int key, int data) {
            this.key = key;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }

    }
}
