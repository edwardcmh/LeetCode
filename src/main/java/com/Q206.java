package com;

import com.cn.LinkList;
import com.cn.ListNode;

public class Q206 {

    /**
     * 206. 反转链表
     *
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     */

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        LinkList l1 = new LinkList();
        l1.addFirst(5);
        l1.addFirst(4);
        l1.addFirst(3);
        l1.addFirst(2);
        l1.addFirst(1);
        l1.traverse();

        Q206 q = new Q206();
        ListNode n1 = q.reverseList(l1.head.next);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
}
