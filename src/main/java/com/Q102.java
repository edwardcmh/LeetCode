package com;

import com.cn.BinaryTree;
import com.cn.TreeNode;

import java.util.*;

public class Q102 {

    /**
     * 102. 二叉树的层序遍历
     *
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * 基本层序遍历（BFS）
     *
     * 解法：双端队列 + 迭代
     *
     * 建立一个循环队列，先将二叉树头结点入队列，然后出队列，访问该结点
     * 如果它有左右子树，则将左右子树的根结点入队。然后出队列，对出队结点访问
     * 如此反复，直到队列为空为止
     *
     * 层序遍历，用二维数组区分每层的节点
     *
     * 解法1：递归 + level变量
     *
     * 解法2：改进基本层序遍历
     *
     * 加一个内层循环，每次取出本层所有的节点，加入下一层所有的节点
     * 取出的本层所有节点初始化添加到List中
     *
     */

    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        recur(list, root, 0);
        return list;
    }

    public void recur(List<List<Integer>> list, TreeNode node, int level) {
        if (list.size() == level)   // 判断新一层数组有没有初始化
            list.add(new ArrayList<>());
        list.get(level).add(node.val);
        // 递归中止条件
        if (node.left != null)
            recur(list, node.left, level + 1);
        if (node.right != null)
            recur(list, node.right, level + 1);
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            // 这里有个坑，要先取队列的size到一个变量里
            // 否则后面入队会改变for循环的判断条件
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                l.add(node.val);
                System.out.println(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            list.add(l);
        }
        return list;
    }


    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        BinaryTree t = new BinaryTree(arr);
        t.traverse();
        Q102 q = new Q102();
//        q.levelOrder(t.root);
        System.out.println(q.levelOrder1(t.root).toString());
        System.out.println(q.levelOrder2(t.root).toString());

    }
}
