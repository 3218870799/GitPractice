package com.xqc.sort;

import java.util.Arrays;

public class BubleSort {
	public static void main(String[] args) {
		//����1����ʼ������
		int[] arr={6,3,8,2,9,1};
		System.out.println("����ǰ����Ϊ��"+Arrays.toString(arr));
		//�������ð������
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
		}
		//����������ʾ���������
        System.out.println("���������Ϊ��"+Arrays.toString(arr));
	}
}
