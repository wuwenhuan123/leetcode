package com.wuwenhuan.leetcode;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[result]) {
                nums[++result] = nums[i];
            }
        }
        return result + 1;
    }


    public static void main(String[] args) {

    }
}
