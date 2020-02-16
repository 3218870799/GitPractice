package com.leetcode.linkedList;

public class LeetCode025 {
	
	public static void main(String[] args) {
		LeetCode025 leetcode = new LeetCode025();
		LeetCode025.Solution solution = leetcode.getSolution();
	}
	public Solution getSolution(){
		return new Solution();
	}
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	class Solution {
		public ListNode reverseKGroup(ListNode head, int k) {
		    ListNode root = new ListNode(-1);
		    root.next = head;
		    ListNode res = root;
		    ListNode temp = head;
		    int i = 0;
		    while(temp != null){
		        i++;
		        temp = temp.next;
		    }//i�����ս���������������нڵ���ܸ���
		    while(i >= k){
		        for(int j = 0 ; j < k-1; j++){//����������н���˼·���з�ת����Ĳ���
		            ListNode node = root.next;//�����k�����Ϊһ����з�ת����Ҫ����k-1�η�ת����
		            root.next = head.next;//����k=3���������β�������2��ת��1ǰ��+��3��ת��1ǰ��
		            head.next = root.next.next;
		            root.next.next = node;
		        }//forѭ��������һ�η�ת����
		        root = head;
		        head = head.next;//��kΪһ�飬��Ҫ��head�ƶ����Ѿ���ת���Ľ����������k�����Ϊһ����з�ת
		        i-=k; //��ʱһ��i������ȥ�Ѿ���ת����k�����õ�ʣ��ڵ����
		    }
		    return res.next;
		}
	}
	
	class BestSolution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	           ListNode current_node = head;
	        int count = 0;
	        while (current_node != null && count != k) {
	            current_node = current_node.next;
	            count++;
	        }
	        if (count == k) {
	            current_node = reverseKGroup(current_node, k);
	            while (count-- > 0) {
	                ListNode temp = head.next;
	                head.next = current_node;
	                current_node = head;
	                head = temp;
	            }
	            head =current_node;
	        }
	        return head;
	    }
	}
	
}
