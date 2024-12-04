package com.wuwenhuan.leetcode;


import java.util.Arrays;

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


    public  int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m]; // LPS数组初始化
        int length = 0; // 前一个最长相同前后缀长度
        lps[0] = 0; // LPS数组的第一个值总是0

        int i = 1; // 从模式的第二个字符开始计算
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++; // 匹配成功，增加length
                lps[i] = length; // 更新LPS值
                i++;
            } else { // 不匹配
                if (length != 0) {
                    length = lps[length - 1]; // 回溯到上一个最长前后缀
                } else {
                    lps[i] = 0; // 没有匹配，LPS为0
                    i++;
                }
            }
        }
        return lps; // 返回计算好的LPS数组
    }

    // KMP算法的主方法
    public  int kmpSearch(String text, String pattern) {
        // 获取文本和模式的长度
        int n = text.length();
        int m = pattern.length();

        // 处理特殊情况
        if (m == 0) return 0; // 如果模式为空，返回0
        if (n < m) return -1; // 如果文本长度小于模式长度，返回-1

        // 创建部分匹配表（LPS数组）
        int[] lps = computeLPSArray(pattern);

        int i = 0; // text的索引
        int j = 0; // pattern的索引

        // 开始匹配过程
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; // 字符匹配，继续比较
                j++;
            }

            if (j == m) { // 找到完整的模式
                return i - j; // 返回模式在文本中的起始位置
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) { // 发生不匹配
                if (j != 0) {
                    j = lps[j - 1]; // 使用LPS数组跳过已比较的字符
                } else {
                    i++; // 如果j为0，继续移动text的索引
                }
            }
        }
        return -1; // 未找到模式，返回-1
    }


    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.strStr("aaa", "aaaa"));



    }
}
