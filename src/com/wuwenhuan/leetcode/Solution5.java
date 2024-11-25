package com.wuwenhuan.leetcode;

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
}
