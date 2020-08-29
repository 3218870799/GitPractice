package com.xqc.binartTree;

/**
 * 
 * @author xqc
 * @data 2020��5��24��
 * Description:
 * ������˳��洢��ʽ
 * 	ǰ�����
 */
public class ArrayBinaryTree {

	int[] data;
	
	public ArrayBinaryTree(int[] data) {
		this.data=data;
	}
	
	public void frontShow() {
		frontShow(0);
	}
	
	//ǰ�����
	public void frontShow(int index) {
		if(data==null||data.length==0) {
			return;
		}
		//�ȱ�����ǰ�ڵ������
		System.out.println(data[index]);
		//2*index+1:����������
		if(2*index+1<data.length) {
			frontShow(2*index+1);
		}
		//2*index+2:����������
		if(2*index+2<data.length) {
			frontShow(2*index+2);
		}
	}
	
}
