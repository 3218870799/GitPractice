package com.leetcode.linkedList;

public class LeetCode148SortList {
    public static void main(String[] args) {

    }
    public ListNode sortListBottomUp(ListNode head) {
        //�п�
        if (head == null) {
            return head;
        }
        //��������
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

  /*  public ListNode sortListTopDown(ListNode head){
        //
        if(head == null || head.next == null){
            return head;
        }
        //ʹ�ÿ���ָ��
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //��������ָ�������ߵ��м�
        ListNode l2 = slow.next;
        slow.next = null;
        return merge(sortListTopDown(head),sortListTopDown(l2));
    }*/

    //�������Ѿ������������кϲ�����û��ȥ��
    //�����ȥ�أ��������ж�ʱ����if(temp<temp1 || temp <temp2)�ٽ��룬����ָ��ֻ������
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead,temp1 = l1,temp2 = l2;
        while (temp1!=null && temp2!=null){
            if (temp1.val <=temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
