package com.xqc.struction;
/**
 * 
 * @author xqc
 * @data 2020��5��24��
 * Description:
 * ˫��ѭ������
 */
public class DoubleLinked {
	//��һ���ڵ�
	DoubleLinked pre=this;
	//��һ���ڵ�
	DoubleLinked next=this;
	//�ڵ�����
	int data;
	
	public DoubleLinked(int data) {
		this.data=data;
	}
	
	//���ڵ�
	public void after(DoubleLinked node) {
		//ԭ������һ���ڵ�
		DoubleLinked nextNext = next;
		//���½ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
		this.next=node;
		//�ѵ�ǰ�ڵ����½ڵ��ǰһ���ڵ�
		node.pre=this;
		//��ԭ������һ���ڵ����½ڵ����һ���ڵ�
		node.next=nextNext;
		//��ԭ������һ���ڵ����һ���ڵ�Ϊ�½ڵ�
		nextNext.pre=node;
	}
	
	//��һ���ڵ�
	public DoubleLinked next() {
		return this.next;
	}
	
	//��һ���ڵ�
	public DoubleLinked pre() {
		return this.pre;
	}
	
	//��ȡ����
	public int getData() {
		return this.data;
	}
	
}
