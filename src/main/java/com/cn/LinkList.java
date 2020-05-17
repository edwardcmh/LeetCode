package com.cn;

public class LinkList {
    public ListNode head;

    public LinkList() {
        head = new ListNode(-1);
        head.next = null;
    }

    /**
     * 头插法
     * @param d
     */
    public void addFirst(int d) {
        ListNode node = new ListNode(d);
        node.next = head.next;
        head.next = node;
    }

    /**
     * 尾插法
     * @param d
     */
    public void addLast(int d) {
        if (head.next == null) {    // 头节点为空时直接插入
            head.next = new ListNode(d);
        } else {      // 否则遍历到末尾插入
            ListNode node = head.next;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(d);
        }
    }

    /**
     * 遍历
     */
    public void traverse() {
        ListNode node = head.next;
        while (node != null) {
            System.out.print(node.val + (node.next == null ? "" : "->"));
            node = node.next;
        }
        System.out.println();
    }
}
