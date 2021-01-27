package com.leetcode.tree.easy;

import java.util.LinkedList;
import java.util.List;

public class Offer34PathSum {

    List<List<Integer>> result = new LinkedList<>();
    List<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //�ݹ�����������
        recur(root,sum);
        return result;
    }
    private void recur(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum-=root.val;
        //�������sum������Ҷ�ӽڵ㣬����һ��;��������
        if (sum == 0 && root.left == null && root.right == null){
            result.add(new LinkedList(path));
        }
        recur(root.left,sum);
        recur(root.right,sum);
    }
}
