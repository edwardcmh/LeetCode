package com;

import java.util.Arrays;

public class Q88 {

    /**
     * 88. 合并两个有序数组
     *
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     *
     * 说明:
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *  
     *
     * 示例:
     *
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     *
     * 解法1：合并后排序
     *
     * 时间复杂度 : O((n+m)log(n+m))
     *
     *
     * 解法2：双指针-从前往后
     *
     * 时间复杂度 : O(n+m)
     * 空间复杂度 : O(m)
     *
     *
     * 解法3：双指针-从后往前
     *
     * 时间复杂度 : O(n+m)
     * 空间复杂度 : O(1)
     *
     *
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        System.arraycopy(nums1, 0, tmp, 0, m);
        int p = 0;      // 指向tmp
        int q = 0;      // 指向nums2
        int i = 0;      // 指向nums1
        while (p < m && q < n) {
            nums1[i++] = tmp[p] < nums2[q] ? tmp[p++] : nums2[q++];
        }
        // 拷贝剩余元素
        if (p < m)
            System.arraycopy(tmp, p, nums1, i, m - p);
        if (q < n)
            System.arraycopy(nums2, q, nums1, i, n - q);
    }


    public static void main(String[] args){
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        Q88 q = new Q88();
        q.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{2, 0};
        nums2 = new int[]{1};
        q.merge2(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));

    }
}
