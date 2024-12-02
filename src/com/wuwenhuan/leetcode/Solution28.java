package com.wuwenhuan.leetcode;


/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle
 * 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class Solution28 {

    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {
            boolean f = true;
            int j = 0;
            while (j < needle.length()) {
                if (i+j >= haystack.length()) {
                    f = false;
                    break;
                }
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    f = false;
                    break;
                }
                j++;
            }
            if (f) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.strStr("aaa", "aaaa"));

    }
}
