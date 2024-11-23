package com.wuwenhuan.leetcode;


import java.util.*;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class Solution56 {
    /**
     * 合并给定的区间数组。
     *
     * @param intervals 一个二维整数数组，其中每个子数组表示一个区间，包含起始和结束值。
     * @return 一个新的二维整数数组，其中包含合并后的不重叠区间。
     */
    public int[][] merge(int[][] intervals) {
        // 如果输入的区间数组为空，则返回一个空数组
        if (intervals.length == 0) {
            return new int[0][0];
        }
        // 根据区间的起始值对区间数组进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // 创建一个列表来存储合并后的区间
        List<int[]> merged = new LinkedList<>();
        // 遍历排序后的区间数组
        for (int[] interval : intervals) {
            // 如果合并列表为空，或者当前区间的起始值大于合并列表中最后一个区间的结束值
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                // 将当前区间添加到合并列表中
                merged.add(interval);
            } else {
                // 否则，更新合并列表中最后一个区间的结束值为当前区间和合并列表中最后一个区间结束值的较大值
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        // 将合并后的列表转换为二维整数数组并返回
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * 合并二维整数数组中的重叠区间
     *
     * @param intervals 二维整数数组，其中每个元素表示一个区间，包含起始和结束值
     * @return 合并后的区间数组，其中每个元素表示一个不重叠的区间
     */
    public int[][] merge2(int[][] intervals) {
        // 对区间数组按照起始值进行排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        // 获取区间数组的长度
        int n = intervals.length;
        // 初始化索引 i 为 0
        int i = 0;
        // 创建一个列表 ranges 用于存储合并后的区间
        List<int[]> ranges = new ArrayList<>(n);
        // 当索引 i 小于区间数组的长度 n 时，执行循环
        while(i < n){
            // 获取当前区间的起始值
            int start = intervals[i][0];
            // 获取当前区间的结束值
            int end = intervals[i][1];
            // 初始化索引 j 为 i + 1
            int j = i + 1;
            // 当索引 j 小于区间数组的长度 n，并且下一个区间的起始值小于等于当前区间的结束值时，执行循环
            while(j < n && intervals[j][0] <= end){
                // 更新当前区间的结束值为当前结束值和下一个区间结束值中的较大值
                end = Math.max(end, intervals[j++][1]);
            }
            // 将合并后的区间 [start, end] 添加到 ranges 列表中
            ranges.add(new int[]{start, end});
            // 更新索引 i 为 j，即跳过已经合并的区间
            i = j;
        }
        // 将 ranges 列表转换为二维整数数组并返回
        return ranges.toArray(new int[ranges.size()][]);
    }



    public static void main(String[] args) {
        Solution56 mi = new Solution56();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = mi.merge(intervals);

        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
