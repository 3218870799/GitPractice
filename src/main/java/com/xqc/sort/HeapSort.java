package com.xqc.sort;

import java.util.Arrays;
/**
 * 
 * @author xqc
 * @data 2020��5��24��
 * Description:
 * ������
 */
public class HeapSort
{
    public static void main(String[] args)
    {
		//����1����ʼ������
		int[] arr={6,3,8,2,9,1};
		System.out.println("����ǰ����Ϊ��"+Arrays.toString(arr));
		//�������������
		HeapSortFaction(arr);
		//����������ʾ���������
        System.out.println("���������Ϊ��"+Arrays.toString(arr));
    }
    //��������
    public static void HeapSortFaction(int[] arr)
    {
        int n = arr.length-1;
        for(int i=(n-1)/2;i>=0;i--)
        {
            //����󶥶ѣ��������Ϲ���
            //iΪ���һ�����ڵ㣬nΪ�������һ��Ԫ�ص��±�
            HeapAdjust(arr,i,n);
        }
        for(int i=n;i>0;i--)
        {
            //����������Ҳ���Ƕ��ŵ����
            //iÿ�μ�һ����ΪҪ�ŵ�λ��ÿ�ζ����ǹ̶���
            swap(arr,i);
            //�ٹ���󶥶�
            HeapAdjust(arr,0,i-1);
        }
    }

    //����󶥶Ѻ�����parentΪ���ڵ㣬lengthΪ�������һ��Ԫ�ص��±�
    public static void HeapAdjust(int[] arr,int parent,int length)
    {
        //������ʱ�����洢���ڵ��е����ݣ���ֹ������
        int temp = arr[parent];
        //2*parent+1�������ӽڵ�
        for(int i=parent*2+1;i<=length;i=i*2+1)
        {
            //������Ӵ����Һ��ӣ�����iָ���Һ���
            if(i<length && arr[i]<arr[i+1])
            {
                i++;
            }
            //������ڵ���ڻ��ߵ��ڽϴ�ĺ��ӣ��Ǿ��˳�ѭ��
            if(temp>=arr[i])
            {
                break;
            }
            //������ڵ�С�ں��ӽڵ㣬�ǾͰѺ��ӽڵ�ŵ����ڵ���
            arr[parent] = arr[i];
            //�Ѻ��ӽڵ���±긳ֵ��parent
            //�������ѭ���Ա�֤����ѹ�����ȷ
            parent = i;
        }
        //���ոյĸ��ڵ��е����ݸ�ֵ����λ��
        arr[parent] = temp;
    }

    //����swap����
    //���ܣ�����Ԫ�������λ�õ�Ԫ�ؽ���
    //ע���������������������ڱ仯��
    public static void swap(int[] arr,int i)
    {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
    }
}