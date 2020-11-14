package com.xqc.sort;

import java.util.Arrays;

/**
 * ϣ������
 * @author Administrator
 *
 */
public class ShellSort {
    public static void main(String []args){
        int []arr ={3,7,2,9,1,4,6,8,10,5};
        ShellSortSwap(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * ϣ������ ������������ڲ���ʱ���ý�����
     * @param arr
     */
    public static void ShellSortSwap(int []arr){
        //����gap��������С����
       for(int gap=arr.length/2;gap>0;gap/=2){
           //�ӵ�gap��Ԫ�أ�����������������ֱ�Ӳ����������
           for(int i=gap;i<arr.length;i++){
               int j = i;
               while(j-gap>=0 && arr[j]<arr[j-gap]){
                   //����������ý�����
                   swap(arr,j,j-gap);
                   j-=gap;
               }
           }
       }
    }
    /**
     * ��������Ԫ��
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
    
    /**
     * ϣ������ ������������ڲ���ʱ�����ƶ�����
     * @param arr
     */
    public static void ShellSortMove(int []arr){
        //����gap��������С����
        for(int gap=arr.length/2;gap>0;gap/=2){
            //�ӵ�gap��Ԫ�أ�����������������ֱ�Ӳ����������
            for(int i=gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0 && temp<arr[j-gap]){
                        //�ƶ���
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
    
}