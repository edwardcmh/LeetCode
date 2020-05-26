package com;

public class Q415 {

    /**
     * 415. 字符串相加
     *
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     *
     * 注意：
     *
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     *
     * 解法：双指针
     *
     * 设置双指针指向两个字符串末尾，逐个数字相加，如果高位不齐补零， 注意最后最高位的进位处理
     *
     */

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int i = c1.length - 1;
        int j = c2.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = Character.getNumericValue(i < 0 ? '0' : c1[i])
                    + Character.getNumericValue(j < 0 ? '0' : c2[j]) + carry;
            int r = sum % 10;
            carry = sum / 10;
            sb.append(r);
            i--;
            j--;
        }
        // 最后一位有进位
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        String str1 = "851";
        String str2 = "269";
        String str3 = "1039";
        Q415 q = new Q415();
        System.out.println(q.addStrings(str1, str2));
        System.out.println(q.addStrings(str2, str3));

    }
}
