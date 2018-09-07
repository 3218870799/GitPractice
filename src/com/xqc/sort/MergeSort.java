package com.xqc.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String []args){
		//����1����ʼ������
		int[] arr={6,3,8,2,9,1};
		System.out.println("����ǰ����Ϊ��"+Arrays.toString(arr));
		//��������鲢����
        int []temp = new int[arr.length];//������ǰ���Ƚ���һ�����ȵ���ԭ���鳤�ȵ���ʱ���飬����ݹ���Ƶ�����ٿռ�
        mergesort(arr,0,arr.length-1,temp);
        //��������������������
        System.out.println("���������Ϊ��"+Arrays.toString(arr));
    }
    private static void mergesort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            mergesort(arr,left,mid,temp);//��߹鲢����ʹ��������������
            mergesort(arr,mid+1,right,temp);//�ұ߹鲢����ʹ��������������
            merge(arr,left,mid,right,temp);//����������������ϲ�����
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//������ָ��
        int j = mid+1;//������ָ��
        int t = 0;//��ʱ����ָ��
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//�����ʣ��Ԫ������temp��
            temp[t++] = arr[i++];
        }
        while(j<=right){//��������ʣ��Ԫ������temp��
            temp[t++] = arr[j++];
        }
        t = 0;
        //��temp�е�Ԫ��ȫ��������ԭ������
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}