package com.xqc.binartTree;
/**
 * 
 * @author xqc
 * @data 2020��5��24��
 * Description:
 * �������ڵ�
 */
public class TreeNode {
	//�ڵ��Ȩ
	int value;
	//�����
	TreeNode leftNode;
	//�Ҷ���
	TreeNode rightNode;
	
	public TreeNode(int value) {
		this.value=value;
	}
	
	//���������
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	//�����Ҷ���
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
}
