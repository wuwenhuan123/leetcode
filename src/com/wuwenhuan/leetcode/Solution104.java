package com.wuwenhuan.leetcode;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class Solution104 {

    /**
     * 递归方式
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    public static void main(String[] args) {
        Integer[] arr = {1, null, 2};
        TreeNode treeNode = TreeNode.createBinaryTree(arr);
        Solution104 solution104 = new Solution104();
        System.out.println(solution104.maxDepth(treeNode));
    }

}
