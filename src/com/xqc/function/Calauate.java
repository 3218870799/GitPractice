package com.xqc.function;

import java.util.HashMap;
import java.util.Map;

public class Calauate{

    public static void main(String[] args){
          CommonMultiply(6, 8);
          Map map = ReturnGcdAndLcm(5,9);
          System.out.println(map.get("gcd"));
          System.out.println(map.get("lcm"));
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
}
