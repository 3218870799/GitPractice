package com.xqc.struction;


/**
 * 
 * @author xqc
 * @data 2020��5��24��
 * Description:
 * ѭ������
 */
public class LoopLinked {

	//�ڵ�����
	int data;
	//��һ���ڵ�
	LoopLinked next=this;
	
	public LoopLinked(int data) {
		this.data=data;
	}
	
	//����һ���ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
	public void after(LoopLinked node) {
		//ȡ����һ���ڵ㣬��Ϊ����һ���ڵ�
		LoopLinked nextNext = next;
		//���½ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
		this.next=node;
		//������һ���ڵ�����Ϊ�½ڵ����һ���ڵ�
		node.next=nextNext;
	}
	
	//ɾ����һ���ڵ�
	public void removeNext() {
		//ȡ������һ���ڵ�
		LoopLinked newNext = next.next;
		//������һ���ڵ�����Ϊ��ǰ�ڵ����һ���ڵ㡣
		this.next=newNext;
	}
	
	//��ȡ��һ���ڵ�
	public LoopLinked next() {
		return this.next;
	}
	
	//��ȡ�ڵ��е�����
	public int getData() {
		return this.data;
	}
	
}
