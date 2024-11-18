package com.wuwenhuan.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
  二叉树
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    /**
     * 将层级遍历的数组转换成二叉树
     *
     * @param arr 数组
     * @return 二叉树
     */
    public static TreeNode createBinaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1; // 从1开始，因为0是根节点

        while (!queue.isEmpty() && index < arr.length) {
            TreeNode current = queue.poll();

            // 处理左子节点
            if (index < arr.length && arr[index] != null) {
                current.left = new TreeNode(arr[index]);
                queue.add(current.left);
            }
            index++;

            // 处理右子节点
            if (index < arr.length && arr[index] != null) {
                current.right = new TreeNode(arr[index]);
                queue.add(current.right);
            }
            index++;
        }
        return root;
    }

}
