package com.xqc.function;

public class Combination {
	
	static int count=0;
	
	public static void main(String[] args) {
		//System.out.println(RecursiveComposition(5,2));
		
		int[] a={1,2,3};
		A(a,0,2);
		System.out.println(count);
		
	}
	private static void A(int[] a, int start, int end) {

		if(start==end){
			for (int x : a) {
				System.out.print(x);
			}
			count++;
			System.out.println();
		}else{
			//���ڴӿ�ʼ��������ÿ������
			for(int i=start;i<=end;i++){

				//ÿ�����ֶ����Է�����ǰ��һ��
				swap(a,start,i);
				//�����˵�һλ����ʣ�µĽ���ȫ����
				A(a,start+1,end);
				//��ֹ�ظ����ٻ�����
				swap(a,start,i);
			}			
		}		
	}
	
	private static void swap(int[] a, int start, int i) {
		int temp=a[start];
		a[start]=a[i];
		a[i]=temp;
	}
	/**
	 * ��a��ѡ��b�ˣ����ؿ���ѡ��ķ�����
	 * @param a
	 * @param b
	 * @return
	 */
	public static int RecursiveComposition(int a ,int b){
		if(b>a){
			return 0;
		}
		if(b==0){
			return 1;
		}
		return RecursiveComposition(a-1,b-1)+RecursiveComposition(a-1,b);
	}


}
