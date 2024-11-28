package com.wuwenhuan.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 */
public class Solution151 {
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public String reverseWords2(String s) {
        s = s.trim();
        int length = s.length();
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                char c = s.charAt(j);
                if (c == ' ') {
                    if (i != j) {
                        wordList.add(0, s.substring(i, j));
                    }
                    i = j;
                    break;
                } else if (j == length - 1) {
                    wordList.add(0, s.substring(i, j + 1));
                    i = j;
                    break;
                }
            }
        }
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        String s = "a good   example";
        System.out.println(solution151.reverseWords2(s));

    }
}
