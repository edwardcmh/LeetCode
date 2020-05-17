package com;

import com.cn.LinkList;
import com.cn.ListNode;

public class Q21 {

    /**
     * 21. 合并两个有序链表
     *
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 解法1：双指针法
     *
     * 两个指针分别指向待排序的链表，判断两个指针指向节点哪个值更小，使用一个头节点指向这个值
     * 然后指针指向链表下一个节点
     * 循环终止时，两个链表有一个是非空的，这时非空链表里的元素比前面所有都要大，因此直接连接剩余元素即可
     *
     * 解法2：递归
     *
     * 1 终止条件
     * 2 单次递归做什么
     * 3 输入什么，返回什么
     *
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1.next;
        ListNode q = l2.next;
        ListNode head = new ListNode(-1);   // 目标链表头节点
        ListNode prev = head;                  // 指向当前比较节点的上一个节点，用于移动指针
        while (p != null && q != null) {
            if (p.val <= q.val) {
                prev.next = p;
                p = p.next;
            } else {
                prev.next = q;
                q = q.next;
            }
            prev = prev.next;
        }
        // 处理其中一个指针到达末尾的情况
        if (p == null)
            prev.next = q;
        if (q == null)
            prev.next = p;
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args){
        // 初始化链表
        LinkList l1 = new LinkList();
        l1.addFirst(4);
        l1.addFirst(2);
        l1.addFirst(1);
        l1.traverse();

        LinkList l2 = new LinkList();
        l2.addFirst(4);
        l2.addFirst(3);
        l2.addFirst(1);
        l2.traverse();

        Q21 q = new Q21();
        ListNode n = q.mergeTwoLists(l1.head, l2.head).next;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }

        ListNode n2 = q.mergeTwoLists2(l1.head.next, l2.head.next).next;
        while (n2 != null) {
            System.out.println(n2.val);
            n2 = n2.next;
        }

    }
}
