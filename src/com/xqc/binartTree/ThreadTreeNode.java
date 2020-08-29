package com.xqc.binartTree;
/**
 * 
 * @author xqc
 * @data 2020��5��24��
 * Description:
 * ���������������ڵ�
 */
public class ThreadTreeNode {
	//�ڵ��Ȩ
	int value;
	//�����
	ThreadTreeNode leftNode;
	//�Ҷ���
	ThreadTreeNode rightNode;
	//��ʶָ������
	int leftType;
	int rightType;
	

	public ThreadTreeNode(int value) {
		this.value=value;
	}
	
	//����������������
	public void threadNodes() {
		threadNodes(this);
	}
	
	public void threadNodes(ThreadTreeNode node) {
		//��ǰ�ڵ����Ϊnull��ֱ�ӷ���
		if(node==null) {
			return;
		}
		//����������
		threadNodes(node.leftNode);
		//����ǰ���ڵ�
		if(node.leftNode==null){
			//�õ�ǰ�ڵ����ָ��ָ��ǰ���ڵ�
			node.leftNode=pre;
			//�ı䵱ǰ�ڵ���ָ�������
			node.leftType=1;
		}
		//����ǰ������ָ�룬���ǰ���ڵ����ָ����null(û��ָ��������)
		if(pre!=null&&pre.rightNode==null) {
			//��ǰ���ڵ����ָ��ָ��ǰ�ڵ�
			pre.rightNode=node;
			//�ı�ǰ���ڵ����ָ������
			pre.rightType=1;
		}
		//ÿ����һ���ڵ㣬��ǰ�ڵ�����һ���ڵ��ǰ���ڵ�
		pre=node;
		//����������
		threadNodes(node.rightNode);
	}
	
	
	
	//���������
	public void setLeftNode(ThreadTreeNode leftNode) {
		this.leftNode = leftNode;
	}
	//�����Ҷ���
	public void setRightNode(ThreadTreeNode rightNode) {
		this.rightNode = rightNode;
	}
	
	//ǰ�����
	public void frontShow() {
		//�ȱ�����ǰ�ڵ������
		System.out.println(value);
		//��ڵ�
		if(leftNode!=null) {
			leftNode.frontShow();
		}
		//�ҽڵ�
		if(rightNode!=null) {
			rightNode.frontShow();
		}
	}

	//�������
	public void midShow() {
		//���ӽڵ�
		if(leftNode!=null) {
			leftNode.midShow();
		}
		//��ǰ�ڵ�
		System.out.println(value);
		//���ӽڵ�
		if(rightNode!=null) {
			rightNode.midShow();
		}
	}

	//�������
	public void afterShow() {
		//���ӽڵ�
		if(leftNode!=null) {
			leftNode.afterShow();
		}
		//���ӽڵ�
		if(rightNode!=null) {
			rightNode.afterShow();
		}
		//��ǰ�ڵ�
		System.out.println(value);
	}

	//ǰ�����
	public ThreadTreeNode frontSearch(int i) {
		ThreadTreeNode target=null;
		//�Աȵ�ǰ�ڵ��ֵ
		if(this.value==i) {
			return this;
		//��ǰ�ڵ��ֵ����Ҫ���ҵĽڵ�
		}else {
			//���������
			if(leftNode!=null) {
				//�п��ܿ��Բ鵽��Ҳ���Բ鲻�����鲻���Ļ���target����һ��null
				target = leftNode.frontSearch(i);
			}
			//�����Ϊ�գ�˵������������Ѿ��ҵ�
			if(target!=null) {
				return target;
			}
			//�����Ҷ���
			if(rightNode!=null) {
				target=rightNode.frontSearch(i);
			}
		}
		return target;
	}
	
	//ɾ��һ������
	public void delete(int i) {
		ThreadTreeNode parent = this;
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

