package com.leetcode.dfs;

public class Offer36treeToDoublyList {
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if (root ==null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if (cur==null) return;
        dfs(cur.left);
        //ǰһ�ڵ����ָ��ָ��ǰ�ڵ�
        if (pre!=null){
            pre.right = cur;
        }else{
            head = cur;
        }
        //��ǰ�ڵ����ָ��ָ��ǰһ�ڵ�
        cur.left = pre;
        //��ǰһ�ڵ�ָ��ǰ�ڵ�
        pre = cur;
        dfs(cur.right);
    }



    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
