package com.wuwenhuan.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution97 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder1(result, root);
        return result;
    }


    /**
     * 递归方式
     */
    private void inorder1(List<Integer> result, TreeNode treeNode) {
        if (treeNode != null) {
            inorder1(result, treeNode.left);
            result.add(treeNode.val);
            inorder1(result, treeNode.right);
        }
    }

    /**
     * 迭代方式
     */
    public void inorder2(List<Integer> result, TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (treeNode != null) {
                stack.add(treeNode);
                treeNode = treeNode.left;
            }
            if (treeNode == null) {
                if (stack.isEmpty()) {
                    break;
                } else {
                    treeNode = stack.pop();
                    result.add(treeNode.val);
                    treeNode = treeNode.right;
                }
            }
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {1, null, 2, 3};
        TreeNode treeNode = TreeNode.createBinaryTree(arr);
        List<Integer> result = new ArrayList<>();
        Solution97 solution97 = new Solution97();
        solution97.inorder2(result, treeNode);
        System.out.println(result);
    }
}
