package com.xqc.sort;

import java.util.Arrays;

public class SeclectionSort {
	public static void main(String[] args) {
		//����1����ʼ������
		int[] arr={6,3,8,2,9,1};
		System.out.println("����ǰ����Ϊ��"+Arrays.toString(arr));
		//�������ѡ������
        for(int i = 0; i < arr.length - 1; i++) {// ����i������
            int k = i;
            for(int j = k + 1; j < arr.length; j++){// ѡ��С�ļ�¼
                if(arr[j] < arr[k]){ 
                    k = j; //����Ŀǰ�ҵ�����Сֵ���ڵ�λ��
                }
            }
            //���ڲ�ѭ��������Ҳ�����ҵ�����ѭ������С�����Ժ��ٽ��н���
            if(i != k){  //����a[i]��a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }    
        }		

		//����������ʾ���������
        System.out.println("���������Ϊ��"+Arrays.toString(arr));
	}
}
