package com.iq;

import com.cn.BinaryTree;
import com.cn.TreeNode;

public class IQ0404 {
    /**
     * 面试题 04.04. 检查平衡性
     *
     * 构造二叉树
     *
     * 若从 0 开始编号，结点 i 的左孩子序号为 2i + 1，右孩子序号为 2i + 2
     *
     * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
     *
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回 true 。
     *
     * 示例 2:
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     * 1
     * / \
     * 2   2
     * / \
     * 3   3
     * / \
     * 4   4
     * 返回 false 。
     *
     * 解法：
     *
     * 先构造二叉树，遍历二叉树，判断当前节点左右子树是否平衡，然后分别判断左右子树是否平衡
     *
     */

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        // 判断当前节点左右子树是否平衡
        if (Math.abs(depth(root.left) - depth(root.right)) > 1)
            return false;
        // 递归判断左右子树是否平衡
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node) {
        // 任意一个节点的高度是两棵子树里高度大的+1
        if (node == null)
            return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        // 构造二叉树
//        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        Integer[] arr = {1, 2, 2, 3, 3, null, null, 4, 4};
        BinaryTree bt = new BinaryTree(arr);
        bt.traverse();
        IQ0404 i = new IQ0404();
        System.out.println(i.isBalanced(bt.root));
    }
}
