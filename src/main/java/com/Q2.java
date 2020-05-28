package com;

import com.cn.LinkList;
import com.cn.ListNode;

public class Q2 {

    /**
     * 2. 两数相加
     *
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 解法：
     *
     * 两个指针分别指向两个链表头节点，依次遍历链表每个节点
     * 设置一个进位，每位数字和=两个指针+进位
     * 进位=和/10，新链表项值=和%10
     * 如果两个链表不一样长，短的补0
     * 链表遍历完成别忘了加进位
     *
     * 顺便练习了单链表头插法和尾插法，实际可以保存一个指向链表最后一个元素的指针，插入时就不用遍历了
     *
     */

    public LinkList addTwoNumbers(LinkList l1, LinkList l2) {
        LinkList list = new LinkList();
        ListNode ni = l1.head.next;
        ListNode nj = l2.head.next;
        int carry = 0;
        while (ni != null || nj != null) {
            if (ni == null)
                ni = new ListNode(0);
            if (nj == null)
                nj = new ListNode(0);
            int sum = ni.val + nj.val + carry;
            carry = sum / 10;
            list.addLast(sum % 10);

            ni = ni.next;
            nj = nj.next;
        }
        if (carry == 1)
            list.addLast(1);
        return list;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);   // 新链表头节点
        ListNode tail = head;       // 指向新链表尾节点
        ListNode ni = l1.next;
        ListNode nj = l2.next;
        int carry = 0;
        while (ni != null || nj != null) {
            if (ni == null)
                ni = new ListNode(0);
            if (nj == null)
                nj = new ListNode(0);
            int sum = ni.val + nj.val + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            ni = ni.next;
            nj = nj.next;
        }
        if (carry == 1)
            tail.next = new ListNode(carry);
        return head;
    }


    public static void main(String[] args){
        LinkList l1 = new LinkList();
//        l1.addFirst(3);
        l1.addFirst(4);
        l1.addFirst(2);
        l1.traverse();

        LinkList l2 = new LinkList();
        l2.addFirst(4);
        l2.addFirst(6);
        l2.addFirst(5);
        l2.traverse();

        Q2 q = new Q2();
        q.addTwoNumbers(l1, l2).traverse();

        ListNode node = q.addTwoNumbers2(l1.head, l2.head);
        ListNode n = node.next;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }

    }
}
