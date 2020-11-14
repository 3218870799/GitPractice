package com.xqc.struction;

import java.util.Arrays;

public class MyArray {

	// ���ڴ洢���ݵ�����
	private int[] elements;

	public MyArray() {
		elements = new int[0];
	}

	// ��ȡ���鳤�ȵķ���
	public int size() {
		return elements.length;
	}

	// �������ĩβ���һ��Ԫ��
	public void add(int element) {
		// ����һ���µ�����
		int[] newArr = new int[elements.length + 1];
		// ��ԭ�����е�Ԫ�ظ��Ƶ���������
		for (int i = 0; i < elements.length; i++) {
			newArr[i] = elements[i];
		}
		// ����ӵ�Ԫ�ط�����������
		newArr[elements.length] = element;
		// ʹ���������滻������
		elements = newArr;
	}

	// ��ӡ����Ԫ�ص�����̨
	public void show() {
		System.out.println(Arrays.toString(elements));
	}

	// ɾ�������е�Ԫ��
	public void delete(int index) {
		// �ж��±��Ƿ�Խ��
		if (index < 0 || index > elements.length - 1) {
			throw new RuntimeException("�±�Խ��");
		}
		// ����һ���µ����飬����Ϊԭ����ĳ���-1
		int[] newArr = new int[elements.length - 1];
		// ����ԭ�����ݵ�������
		for (int i = 0; i < newArr.length; i++) {
			// ��Ҫɾ����Ԫ��ǰ���Ԫ��
			if (i < index) {
				newArr[i] = elements[i];
				// ��Ҫɾ����Ԫ�غ����Ԫ��
			} else {
				newArr[i] = elements[i + 1];
			}
		}
		// �������滻������
		elements = newArr;
	}

	// ȡ��ָ��λ�õ�Ԫ��
	public int get(int index) {
		// �ж��±��Ƿ�Խ��
		if (index < 0 || index > elements.length - 1) {
			throw new RuntimeException("�±�Խ��");
		}
		return elements[index];
	}

	// ����һ��Ԫ�ص�ָ��λ��
	public void insert(int index, int element) {
		// ����һ���µ�����
		int[] newArr = new int[elements.length + 1];
		// ��ԭ�����е�Ԫ�ط����������С�
		for (int i = 0; i < elements.length; i++) {
			// Ŀ��λ��֮ǰ��Ԫ��
			if (i < index) {
				newArr[i] = elements[i];
				// Ŀ��λ��֮���Ԫ��
			} else {
				newArr[i + 1] = elements[i];
			}
		}
		// �����µ�Ԫ��
		newArr[index] = element;
		// �������滻������
		elements = newArr;
	}

	// �滻ָ��λ�õ�Ԫ��
	public void set(int index, int element) {
		// �ж��±��Ƿ�Խ��
		if (index < 0 || index > elements.length - 1) {
			throw new RuntimeException("�±�Խ��");
		}
		elements[index] = element;
	}
	
	//���Բ���
	public int search(int target) {
		//��������
		for(int i=0;i<elements.length;i++) {
			if(elements[i]==target) {
				return i;
			}
		}
		//û���ҵ���Ӧ��Ԫ��
		return -1;
	}
	
	//���ַ�����
	public int binarySearch(int target) {
		//��¼��ʼλ��
		int begin = 0;
		//��¼����λ��
		int end = elements.length-1;
		//��¼�м��λ��
		int mid = (begin+end)/2;
		//ѭ������
		while(true) {
			//ʲô�����û�����Ԫ�أ�
			//��ʼ�ڽ���λ��֮����غ�,û�����Ԫ��
			if(begin>=end) {
				return -1;
			}
			//�ж��м�����Ԫ���ǲ���Ҫ���ҵ�Ԫ��
			if(elements[mid]==target) {
				return mid;
				//�м����Ԫ�ز���Ҫ���Ԫ��
			}else{
				//�ж��м����Ԫ���ǲ��Ǳ�Ŀ��Ԫ�ش�
				if(elements[mid]>target) {
					//�ѽ���λ�õ������м�λ��ǰһ��λ��
					end=mid-1;
				//�м����Ԫ�ر�Ŀ��Ԫ��С
				}else {
					//�ѿ�ʼλ�õ������м�λ�õĺ�һ��λ��
					begin = mid+1;
				}
				//ȡ���µ��м�λ��
				mid=(begin+end)/2;
			}
		}
	}

}
