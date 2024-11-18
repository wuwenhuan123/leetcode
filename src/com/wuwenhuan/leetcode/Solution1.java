package com.wuwenhuan.leetcode;

import java.util.Arrays;
import java.util.HashMap;


/*
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 */
class Solution1 {

    /**
     * 解法1：暴力循环解法，时间复杂度O(n*n)
     */
    static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 解法2：使用map,对于每一个元素X，查询map中是否存在target-x，如果不存在则将x存入map当中
     * 这样可以避免x与自身匹配。时间复杂度就是n次比较，为O(n)
     */
    static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey((target - nums[i]))) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11};
        int target = 10;

        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }
}