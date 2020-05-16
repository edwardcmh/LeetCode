package com.cn;

public class Q11 {

    // 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    //
    //说明：你不能倾斜容器，且 n 的值至少为 2。
    //
    //示例：
    //
    //输入：[1,8,6,2,5,4,8,3,7]
    //输出：49
    public int maxArea(int[] height) {
        int p = 0, q = height.length - 1;
        int maxArea = 0;
        while (p < q) {
            int len = q - p;
            int area = len * Math.min(height[p], height[q]);
            if (area > maxArea)
                maxArea = area;
            if (height[p] < height[q])
                p++;
            else
                q--;
        }
        return maxArea;
    }

    public static void main(String[] args){
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Q11 q = new Q11();
        System.out.println(q.maxArea(arr));

    }
}
