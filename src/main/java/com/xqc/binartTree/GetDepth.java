package com.xqc.binartTree;


public class GetDepth {
    // ��ȡ������
    public static int getMaxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int left = getMaxDepth(root.left);
            int right = getMaxDepth(root.right);
            return 1 + Math.max(left, right);
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
