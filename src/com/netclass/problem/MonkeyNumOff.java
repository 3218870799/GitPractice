package com.netclass.problem;

import java.util.Scanner;

/**
 * 
 * @author xqc
 * @data 2020��3��22��
 * Description:
 *һȺ�����ų�һȦ����1��2������n���α�š�
 *Ȼ��ӵ�1ֻ��ʼ����������mֻ,�����߳�Ȧ��
 *���������ٿ�ʼ������������mֻ���ڰ����߳�ȥ����
 *��˲�ͣ�Ľ�����ȥ��ֱ�����ֻʣ��һֻ����Ϊֹ����ֻ���Ӿͽ���������
 *Ҫ����ģ��˹��̣�����m��n, �������Ǹ������ı�š�
 */
public class MonkeyNumOff {
	public static void main(String[] args) {
/*		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();*/
		int result = GetKing(3,17);
		System.out.println(result);
	}

	private static int GetKing(int m, int n) {
		int[] monkey = new int[n+1];
		//��ÿ�����ӱ��
		for (int i = 0; i < monkey.length; i++) {
			monkey[i]= i+1;
		}
		int count =0;
		//����ʣ�º���
		while(n>0){
			//����ÿ������
			for (int i = 0; i < monkey.length; i++) {
				//����ú���û�б���̭��������һ
				if(monkey[i]!=0){
					count++;
					//���������ú���Ϊ��Ҫ��̭�ĺ���
					if(count==m){
						//��̭���ӣ��������㣬��������һ
						monkey[i]=0;
						count=0;
						n--;
					}
				}
			}
		}
		for (int i = 0; i < monkey.length; i++) {
			if(monkey[i]!=0){
				//return i;
				System.out.println(i);
			}
		}
		return -1;
	}

}
