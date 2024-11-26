package com.wuwenhuan.leetcode;

/**
 * 最长回文子串
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int max = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = longestPalindrome(s, i, i);
            if (temp.length() > max) {
                max = temp.length();
                result = temp;
            }
            temp = longestPalindrome(s, i, i + 1);
            if (temp.length() > max) {
                max = temp.length();
                result = temp;
            }
        }
        return result;
    }

    private String longestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public String longestPalindrome2(String s) {
        if (s.length()<=1){
            return s;
        }
        for (int length = s.length(); length > 0; length--) {
            for (int left = 0; left + length <= s.length(); left++) {
                String substring = s.substring(left, left + length);
                if (isPalindrome(substring)) {
                    return substring;
                }
            }
        }

        return null;
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "abb";
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome2(s));
    }
}
