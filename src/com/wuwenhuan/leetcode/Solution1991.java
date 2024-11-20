package com.wuwenhuan.leetcode;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，请你找到 最左边 的中间位置 middleIndex （也就是所有可能中间位置下标最小的一个）。
 * <p>
 * 中间位置 middleIndex 是满足 nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1] 的数组下标。
 * <p>
 * 如果 middleIndex == 0 ，左边部分的和定义为 0 。类似的，如果 middleIndex == nums.length - 1 ，右边部分的和定义为 0 。
 * <p>
 * 请你返回满足上述条件 最左边 的 middleIndex ，如果不存在这样的中间位置，请你返回 -1 。
 */
public class Solution1991 {

    /**
     * 先算出总和，累加每次遍历的数，再用总和减去遍历当前值，如果等于累加的值就算成功
     */
    public int findMiddleIndex(int[] nums) {
        int total = 0;
        int temp = 0;
        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (((total - nums[i]) - temp == temp)) {
                return i;
            } else {
                temp += nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        Solution1991 solution1991 = new Solution1991();
        System.out.println(solution1991.findMiddleIndex(nums));
    }
}
