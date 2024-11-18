package com.wuwenhuan.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class Solution145 {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder2(result, root);
        return result;
    }

    /**
     * 递归方式
     */
    public void postorder1(List<Integer> result, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postorder1(result, treeNode.left);
        postorder1(result, treeNode.right);
        result.add(treeNode.val);
    }

    /**
     * 迭代方式
     */
    public void postorder2(List<Integer> result, TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = treeNode;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                result.add(0, temp.val);
                temp = temp.right;
            } else {
                temp = stack.pop();
                temp = temp.left;
            }
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {1,null,2,3};
        TreeNode treeNode = TreeNode.createBinaryTree(arr);
        Solution145 solution145 = new Solution145();
        List<Integer> result = solution145.postorderTraversal(treeNode);
        System.out.println(result);
    }

}
