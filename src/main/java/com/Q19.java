package com;

import com.cn.LinkList;
import com.cn.ListNode;

public class Q19 {

    /**
     * 19. 删除链表的倒数第N个节点
     *
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     *
     * 解法：
     *
     * 使用双指针，第一个指针先走n+1步，第二个指针再同步走
     * 当第一个指针到达链表末尾时，这时第二个指针指向要删除节点的上一个节点，再执行删除操作
     *
     * 注意考虑边界条件，链表只有一个节点的情况
     * 如果传入的链表没有头节点，则应该建立一个dummy作为头节点，避免删除唯一的节点后方法的返回值问题
     *
     * 如果使用两次遍历的方法，第一次遍历计算出链表长度，则len-n+1个节点就是要删除的节点
     * 第二次遍历到len-n个节点处停下，对下一个节点做删除操作
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        int span = n + 1;
        while (p != null && q != null) {
            if (span-- <= 0)
                p = p.next;
            q = q.next;
        }
        // 这时第一个指针来到末尾
        p.next = p.next.next;
        return head;
    }


    public static void main(String[] args){
        // 初始化链表
        LinkList list = new LinkList();
//        list.addFirst(5);
//        list.addFirst(4);
//        list.addFirst(3);
//        list.addFirst(2);
        list.addFirst(1);
        list.traverse();

        Q19 q = new Q19();
        ListNode n = q.removeNthFromEnd(list.head, 1).next;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }

    }

}
