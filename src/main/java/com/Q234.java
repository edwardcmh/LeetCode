package com;

import com.cn.LinkList;
import com.cn.ListNode;

public class Q234 {

    /**
     * 234. 回文链表
     *
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     *
     * 解法：找到链表中点 + 反转链表后半部 + 双指针遍历
     *
     */

    public boolean isPalindrome(ListNode head) {
        // 快慢指针找中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转链表后半部
        ListNode last = reverseList(slow);
        // pre是后半部链表的头，采用双指针法对比每个元素
        ListNode p = head;
        ListNode q = last;
        while (p != q && q != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        // 恢复链表后半部
        reverseList(last);
        return true;
    }

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
        // 初始化链表
        LinkList l1 = new LinkList();
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(2);
        l1.addFirst(1);
        l1.traverse();

        Q234 q = new Q234();
        System.out.println(q.isPalindrome(l1.head.next));

    }
}
