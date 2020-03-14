package com.xqc.binartTree;

/**
 * �ж��ǲ���ƽ�����������������֮�����ֵ������1
 * @author xqc
 * @data 2020��2��17��
 * Description:
 */
public class IsBalancedTree {

	//�������ڵ�����
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * �ж��Ƿ�Ϊ���������Ƿ���true�����Ƿ���false
	 * @param head
	 * @return
	 */
	public static boolean isBalance(Node head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 1, res);
		return res[0];
	}
	/**
	 * �ݹ��ж����������߶ȣ����ڷ������������߶�֮�����1ʱ��res��Ϊfalse
	 * @param head
	 * @param level
	 * @param res
	 * @return head���ĸ߶�
	 */
	public static int getHeight(Node head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}
		//�ݹ��ж������Ƿ�ƽ�Ⲣ�õ���߶�
		int lH = getHeight(head.left, level + 1, res);
		//�����ƽ���򷵻���������߶�
		if (!res[0]) {
			return level;
		}
		//����
		int rH = getHeight(head.right, level + 1, res);
		if (!res[0]) {
			return level;
		}
		//�ж����������߶�֮�����1������Ϊ��ƽ��
		if (Math.abs(lH - rH) > 1) {
			res[0] = false;
		}
		return Math.max(lH, rH);
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		System.out.println(isBalance(head));

	}

}
