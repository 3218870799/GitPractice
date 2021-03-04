package com.leetcode.tree.easy;

public class LeetCode112HasPathSum {


    //�ݹ鷽�����
    public boolean hasPathSumMethod1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //����Ǹ��ڵ����val == sum ����
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        //����������һ��������
        return hasPathSumMethod1(root.left, sum - root.val) || hasPathSumMethod1(root.right, sum - root.val);
    }

}
