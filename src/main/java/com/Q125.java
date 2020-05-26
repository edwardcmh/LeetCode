package com;

public class Q125 {

    /**
     * 125. 验证回文串
     *
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     *
     * 解法：双指针
     *
     * 将字符串转字符数组，然后设置双指针，各指向数组首位
     * 移动指针，各找到合法字符进行比较，如果不相等，则不是回文
     *
     */

    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        System.out.println(str);
        char[] charArr = str.toCharArray();
        int i = 0, j = charArr.length - 1;
        while (i < j) {
            if (charArr[i] != charArr[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        char[] charArr = s.toCharArray();
        int i = 0, j = charArr.length - 1;
        while (i < j) {
            // 如果不是字母和数字，找下一个
            while (!Character.isLetterOrDigit(charArr[i]) && i < j) i++;
            while (!Character.isLetterOrDigit(charArr[j]) && i < j) j--;
            // i和j都找到一个合法字符
            if (Character.toLowerCase(charArr[i]) != Character.toLowerCase(charArr[j]))
                return false;
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        Q125 q = new Q125();
        System.out.println(q.isPalindrome(str));
        System.out.println(q.isPalindrome2(str));

    }
}
