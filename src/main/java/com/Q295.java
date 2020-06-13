package com;

import java.util.PriorityQueue;

public class Q295 {

    /**
     * 295. 数据流的中位数
     *
     * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
     *
     * 例如，
     *
     * [2,3,4] 的中位数是 3
     *
     * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     *
     * 设计一个支持以下两种操作的数据结构：
     *
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     * 示例：
     *
     * addNum(1)
     * addNum(2)
     * findMedian() -> 1.5
     * addNum(3)
     * findMedian() -> 2
     * 进阶:
     *
     * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
     * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
     *
     * 解法：
     *
     * 设置两个堆，一个最小堆，一个最大堆，逐个将数据流从两个堆中经过，最后，
     * 最小堆的元素代表数据流的后半部分，最大堆的元素代表数据流的前半部分
     *
     * 注意：两个堆元素个数之和为奇数时，需要保证大堆中的元素比小堆中多1
     *
     * 总个数是偶数时：
     * 最大堆的堆顶元素与最小堆的堆顶元素之和的平均值是中位数
     *
     * 总个数是奇数时：
     * 最大堆的堆顶元素就是中位数
     *
     */

    public PriorityQueue<Integer> maxHeap;
    public PriorityQueue<Integer> minHeap;
    public int count;

    /** initialize your data structure here. */
    public Q295() {
        maxHeap = new PriorityQueue<Integer>((x,y)->y-x);
        minHeap = new PriorityQueue<Integer>();
        count = 0;
    }

    public void addNum(int num) {
        count++;
         maxHeap.offer(num);
         minHeap.offer(maxHeap.poll());
//        minHeap.offer(num);
//        maxHeap.offer(minHeap.poll());
        if ((count & 1) != 0 )
            maxHeap.offer(minHeap.poll());
//            minHeap.offer(maxHeap.poll());
    }

    public double findMedian() {
        if ((count & 1) == 0)
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
//            return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 20, 7, 11, 14, 6};
        Q295 q = new Q295();
        for (int a : arr) {
            q.addNum(a);
        }
        System.out.println(q.findMedian());

    }
}
