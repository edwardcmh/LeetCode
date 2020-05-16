package com.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {

    //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
    //
    //注意：答案中不可以包含重复的三元组。
    //
    //示例：
    //
    //给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    //
    //满足要求的三元组集合为：
    //[
    //  [-1, 0, 1],
    //  [-1, -1, 2]
    //
    // 解法：排序+标兵+双指针
    //
    // 排序后
    // 1。如果标兵指的数本身大于0，那三数之和肯定无法等于零
    // 2。如果和大于0，说明右指针指的数大，右指针左移
    // 3。如果和小于0，说明左指针指的数小，左指针右移
    // 4。如果相邻元素有重复值，跳过
    //
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);  // 排序
        int i, j;
        for (int p = 0; p < nums.length - 2; p++) {
            i = p + 1;
            j = nums.length - 1;
            if (nums[p] > 0)    // 如果当前数字大于0，则三数之和一定大于0
                break;
            if (p > 0 && nums[p] == nums[p - 1])     // 去重
                continue;
            while (i < j) {
                int sum = nums[p] + nums[i] + nums[j];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[p], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i+1]) i++;   // 去重
                    while (i < j && nums[j] == nums[j-1]) j--;   // 去重
                    i++;
                    j--;
                } else if (sum > 0)
                    j--;
                else if (sum < 0)
                    i++;
            }
        }
        return list;
    }

    public static void main(String[] args){
//        int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr = {0, 0, 0};
        Q15 q = new Q15();
        System.out.println(q.threeSum(arr).toString());

    }
}
