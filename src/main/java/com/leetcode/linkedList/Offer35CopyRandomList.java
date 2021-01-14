package com.leetcode.linkedList;

import java.util.HashMap;

public class Offer35CopyRandomList {
    public static void main(String[] args) {

    }
    public Node copyRandomListByHashMap(Node head) {
        //����HashMap����
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        //���ƽ��ֵ
        while (cur!=null){
            //�洢put:<key,value1>
            //˳��������洢�Ͻ����½��(�ȴ洢�´����Ľ��ֵ)
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        //���ƽ��ָ��
        cur = head;
        while (cur!=null){
            //�õ�get:<key>.value2,3
            //�½��nextָ��ͬ�ɽ���nextָ��
            map.get(cur).next = map.get(cur.next);
            //�½��randomָ��ͬ�ɽ���randomָ��
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        //���ظ��Ƶ�����
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
