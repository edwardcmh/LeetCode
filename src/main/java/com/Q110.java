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
     * 解法1：从顶至底（时间复杂度高）
     *
     * 解法2：从底至顶（最优解）
     *
     *
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


    public boolean isBalanced2(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode node) {
        if (node == null)   // 递归终止条件，返回高度0
            return 0;
        // 如果左右子树里有一个不平衡，则父节点都不平衡，返回不平衡-1
        int left = recur(node.left);
        if (left == -1)
            return -1;
        int right = recur(node.right);
        if (right == -1)
            return -1;
        // 如果左右子树高度相差小于2，返回较大的高度
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    public static void main(String[] args) {
//        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        Integer[] arr = {1, 2, 2, 3, 3, null, null, 4, 4};
        BinaryTree t = new BinaryTree(arr);
        t.traverse();
        Q110 q = new Q110();
        System.out.println(q.isBalanced(t.root));
        System.out.println(q.isBalanced2(t.root));

    }
}
