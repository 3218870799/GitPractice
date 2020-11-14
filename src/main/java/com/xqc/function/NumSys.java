package com.xqc.function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumSys {
	
	public static void main(String[] args) {
		
		//�ҳ���101,��200����������
		//getPrimeNum(101,200);
		
		//��6��8�����Լ������С������
 /*       CommonMultiply(6, 8);
        Map map = ReturnGcdAndLcm(5,9);
        System.out.println(map.get("gcd"));
        System.out.println(map.get("lcm"));*/
        
        
        //��n����������
        int[] result = GetFactorArray(30);
        for (int i : result) {
        	if(i!=0)System.out.println(i);
		}
        
        //�������е�����
/*		int[] a ={2,4,5,6,2,4,4,6};
		int most = GetMostNum(a);
		System.out.println(most);*/
	}
	//��n���������Ӳ���ŵ������з���
	private static int[] GetFactorArray(int n) {
		// TODO Auto-generated method stub
		int[] result = new int[n];
		result[0]=1;
		result[1]=n;
		int count=2;
		for (int i = 2; i < Math.sqrt(n); i++) {
			if(n%i==0){
				result[count++]=i;
				result[count++]=n/i;
			}
		}
		
		
		return result;
	}

	/**
	 * �ҳ���low��high����������
	 * @param low
	 * @param high
	 */
	private static void getPrimeNum(int low, int high) {
		boolean flag;
		//����ÿһ����low��high����
		for (int i = low; i <high; i+=2) {
			flag=true;
			//�жϸ����ǲ�������
			for (int j = 2; j <=Math.sqrt(i); j++) {
				//���������2��ʼ���������п��Գ����ģ��Ͳ��ǣ��ж���һ����
				if(i%j==0){
					flag = false;
					break;
				}		
			}
			if(flag==true){
				System.out.println(i);
			}
			
		}
		
	}
	  /**
	   * �����Լ������С������  
	   * @param m
	   * @param n
	   * @return
	   */
	    public static int CommonMultiply(int m ,int n){
	        int r,gcd,lcm=0;

	        lcm=m*n;
	        while((r=m%n)!=0){
	              m=n;
	              n=r;
	        }
	        gcd = n;
	        lcm=lcm/gcd;
	        System.out.println("���Լ����"+gcd);
	        System.out.println("��С��������"+lcm);
	        return 0;
	    }
	    /**
	     * �������Լ������С������
	     * @param m
	     * @param n
	     * @return
	     */
	    public static Map<String,Integer> ReturnGcdAndLcm(int m,int n){
	    	Map<String,Integer> map = new HashMap<String,Integer>();
	    	int r,gcd,lcm=0;
	    	
	    	lcm=m*n;
	    	while((r=m%n)!=0){
	    		m=n;
	    		n=r;
	    	}
	    	gcd = n;
	    	lcm=lcm/gcd;
	    	map.put("gcd", gcd);
	    	map.put("lcm", lcm);   	
	    	return map;
	    	
	    }
	    
		private static int GetMostNum(int[] array) {
			//����������
	        Arrays.sort(array);
	        int count = 1;
	        int longest = 0;
	        int most = 0;
	        //���������ж�ÿ�����Ĵ���
	        for (int i = 0; i < array.length - 1; i++) {
	        	//������ں�һ����������һ
	            if (array[i] == array[i + 1]) {
	                count++;
	            } else {
	                count = 1;// ��������ڣ��ͻ�������һ��������ô������һ�����Ĵ���ʱ��count��ֵӦ�����·�ֵΪһ
	                continue;
	            }
	            //�жϸü����ǲ�������
	            if (count > longest) {
	                most = array[i];
	                longest = count;
	            }
	        }
	        System.out.print("���ִ���:" + longest);// ��ӡ����������ֵĴ������ж��Ƿ���ȷ
	        System.out.println(" ");
	        System.out.print("����Ϊ:");
	        return most;
		}

}
