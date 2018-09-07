package com.xqc.sort;

import java.util.Arrays;

public class CountSort {
	
    public static void main(String[] args)
    {
    	//��ʼ������
        int[] A=new int[]{6,3,8,6,3,1,3};
        //��ӡ
        System.out.println("����ǰ����Ϊ��"+Arrays.toString(A));
        //��������
        int[] B=countSort(A, 8);
        //��ӡ
        System.out.println("���������Ϊ��"+Arrays.toString(B));
    }

    private static int[] countSort(int[] array,int k)
    {
        int[] count=new int[k+1];//����count����
        int length=array.length,sum=0;//��ȡA�����С���ڹ���B����  
        int[] B=new int[length];//����B����
        for(int i=0;i<length;i++)
        {
            count[array[i]]+=1;// ͳ��A�и�Ԫ�ظ���������C����
        }
        for(int i=0;i<k+1;i++)//�޸�C����
        {
            sum+=count[i];
            count[i]=sum;    
        }
        for(int i=length-1;i>=0;i--)//����A���飬����B����
        {
            
            B[count[array[i]]-1]=array[i];//��A�и�Ԫ�طŵ����������B��ָ����λ��
            count[array[i]]--;//��C�и�Ԫ��-1����������һ��ͬ����С��Ԫ��
            
        }
        return B;//������õ����鷵�أ��������
        
    }
}