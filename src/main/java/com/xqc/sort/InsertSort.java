package com.xqc.sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		//����1����ʼ������
		int[] arr={6,3,8,2,9,1};
		System.out.println("����ǰ����Ϊ��"+Arrays.toString(arr));
		//���������������
		//��δ�����������ȡ����һ��
		for(int i=1;i<arr.length;i++){
			int tempdata = arr[i];
			int j;
			//Ѱ�Һ��ʵĲ���λ�ã��Ӻ���ǰ�ߣ�������������������������ƶ�һ
			for(j=i-1;j>=0;j--){
				if(arr[j]>tempdata){
					arr[j+1] = arr[j];
				}else{
					break;
				}
			}
			//Ѱ�ҵ�����λ�ã���ȡ���������ڸ�λ��
			arr[j+1] = tempdata;
		}

		//����������ʾ���������
        System.out.println("���������Ϊ��"+Arrays.toString(arr));
	}
}
