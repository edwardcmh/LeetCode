package com;

import com.cn.BinaryTree;
import com.cn.TreeNode;

public class Q110 {

    /**
     * 110. 平衡二叉树
     *
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
     *
     * 示例 1:
     *
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     *
     * 示例 2:
     *
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * 返回 false 。
     *
     */

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(depth(root.left) - depth(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    public static void main(String[] args) {
//        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        Integer[] arr = {1, 2, 2, 3, 3, null, null, 4, 4};
        BinaryTree t = new BinaryTree(arr);
        t.traverse();
        Q110 q = new Q110();
        System.out.println(q.isBalanced(t.root));

    }
}
