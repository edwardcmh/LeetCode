package com.cn;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree(Integer[] array) {
        root = createBinaryTree(array, 0);
    }

    /**
     * 构造二叉树
     * 若从 0 开始编号，结点 i 的左孩子序号为 2i + 1，右孩子序号为 2i + 2
     */
    public TreeNode createBinaryTree(Integer[] array, int i) {
        TreeNode node = null;
        if (i < array.length && array[i] != null) {
            node = new TreeNode(array[i]);
            node.left = createBinaryTree(array, 2 * i + 1);
            node.right = createBinaryTree(array, 2 * i + 2);
        }
        return node;
    }

    public void traverse() {
        preOrder(root);

    }

    /**
     * 先序遍历
     */
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.val);
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历
     */
    public void PostOrder(TreeNode node) {
        if (node != null) {
            PostOrder(node.left);
            PostOrder(node.right);
            System.out.println(node.val);
        }
    }

}
