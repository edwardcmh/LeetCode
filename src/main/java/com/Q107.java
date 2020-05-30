package com;

import com.cn.BinaryTree;
import com.cn.TreeNode;

import java.util.*;

public class Q107 {

    /**
     * 107. 二叉树的层次遍历 II
     *
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其自底向上的层次遍历为：
     *
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     *
     */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        if (root==null) return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                l.add(node.val);
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
            }
            list.addFirst(l);
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        BinaryTree t = new BinaryTree(arr);
        t.traverse();
        Q107 q = new Q107();
        System.out.println(q.levelOrderBottom(t.root).toString());

    }
}
