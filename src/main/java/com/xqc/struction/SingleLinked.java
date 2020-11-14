package com.xqc.struction;

/**
 * @author xqc
 * @data 2020��5��24��
 * Description:
 * ������
 */
public class SingleLinked {

	//�ڵ�����
	int data;
	//��һ���ڵ�
	SingleLinked next;
	
	public SingleLinked(int data) {
		this.data=data;
	}
	
	//Ϊ����ͷ�ڵ�׷�ӽڵ�
	public SingleLinked append(SingleLinked node) {
		//��ǰ�ڵ�
		SingleLinked currentNode = this;
		//ѭ�������
		while(true) {
			//ȡ����һ���ڵ�
			SingleLinked nextNode = currentNode.next;
			//�����һ���ڵ�Ϊnull,��ǰ�ڵ��Ѿ������һ���ڵ�
			if(nextNode==null) {
				break;
			}
			//������ǰ�ڵ�
			currentNode = nextNode;
		}
		//����Ҫ׷�صĽڵ�׷��Ϊ�ҵ��ĵ�ǰ�ڵ����һ���ڵ�
		currentNode.next=node;
		return this;
	}
	
	//����һ���ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
	public void after(SingleLinked node) {
		//ȡ����һ���ڵ㣬��Ϊ����һ���ڵ�
		SingleLinked nextNext = next;
		//���½ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
		this.next=node;
		//������һ���ڵ�����Ϊ�½ڵ����һ���ڵ�
		node.next=nextNext;
	}
	
	//��ʾ���нڵ���Ϣ
	public void show() {
		SingleLinked currentNode = this;
		while(true) {
			System.out.print(currentNode.data+" ");
			//ȡ����һ���ڵ�
			currentNode=currentNode.next;
			//��������һ���ڵ�
			if(currentNode==null) {
				break;
			}
		}
		System.out.println();
	}
	
	//ɾ����һ���ڵ�
	public void removeNext() {
		//ȡ������һ���ڵ�
		SingleLinked newNext = next.next;
		//������һ���ڵ�����Ϊ��ǰ�ڵ����һ���ڵ㡣
		this.next=newNext;
	}
	
	//��ȡ��һ���ڵ�
	public SingleLinked next() {
		return this.next;
	}
	
	//��ȡ�ڵ��е�����
	public int getData() {
		return this.data;
	}
	
	//��ǰ�ڵ��Ƿ������һ���ڵ�
	public boolean isLast() {
		return next==null;
	}
	
}

