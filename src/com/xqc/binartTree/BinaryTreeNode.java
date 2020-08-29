package com.xqc.binartTree;
/**
 * 
 * @author xqc
 * @data 2020��5��24��
 * Description:
 * �������ڵ�
 */
public class BinaryTreeNode {
	//�ڵ��Ȩ
	int value;
	//�����
	BinaryTreeNode leftNode;
	//�Ҷ���
	BinaryTreeNode rightNode;
	
	public BinaryTreeNode(int value) {
		this.value=value;
	}
	
	//���������
	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}
	//�����Ҷ���
	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
	/**
	 * ɾ����������iΪ���ڵ������
	 * @param i
	 */
	public void delete(int i) {
		BinaryTreeNode parent = this;
		//�ж������
		if(parent.leftNode!=null&&parent.leftNode.value==i) {
			parent.leftNode=null;
			return;
		}
		//�ж��Ҷ���
		if(parent.rightNode!=null&&parent.rightNode.value==i) {
			parent.rightNode=null;
			return;
		}
		
		//�ݹ��鲢ɾ�������
		parent=leftNode;
		if(parent!=null) {
			parent.delete(i);
		}
		
		//�ݹ��鲢ɾ���Ҷ���
		parent=rightNode;
		if(parent!=null) {
			parent.delete(i);
		}
	}
	
	
}
