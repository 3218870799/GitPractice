package com.leetcode.tree.medium;

import java.util.HashMap;
import java.util.Map;

public class Offer07BuildTree {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //�п�
        if (preorder == null || inorder ==null || preorder.length==0 ||inorder.length==0){
            return null;
        }
        //ʹ��һ�� Map �洢���������ÿ��Ԫ�ؼ����Ӧ���±꣬Ŀ����Ϊ�˿��ٻ��һ��Ԫ������������е�λ�á�
        Map<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
        int length = preorder.length;
        for (int i =0;i<length;i++){
            indexMap.put(inorder[i],i);
        }
        TreeNode root = buildTreeHelp(preorder,0,length-1,inorder,0,length-1,indexMap);
        return root;
    }
    public TreeNode buildTreeHelp(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        //
        if (preorderStart > preorderEnd) {
            return null;
        }
        //���ڵ�Ϊǰ������ĵ�һ���ڵ�
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        //�ݹ���ڣ���ֻ��һ���ڵ�ʱ�����ظýڵ�
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            //�ҵ����ڵ��ں��������е�λ��
            int rootIndex = indexMap.get(rootVal);
            //�������ڵ������ڸ��ڵ�������ȥ������ʼ�������������ڵ������ں����Ľ���������ȥ���ڵ�����
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            //�ݹ���������
            TreeNode leftSubtree = buildTreeHelp(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTreeHelp(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
