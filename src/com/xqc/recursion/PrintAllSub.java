package com.xqc.recursion;

/**
 * 
 * ��ӡһ���ַ������е��Ӵ�
 */
public class PrintAllSub {
	
	/**
	 * 
	 * @param str �ܴ�
	 * @param i ��ǰλ��
	 * @param parent ��һ�β����������ַ���
	 */
	public static void printAllSubsquence(char[] str,int i,String parent){
		if(i==str.length){
			System.out.println(parent);
			return;
		}
		printAllSubsquence(str, i+1, parent);
		printAllSubsquence(str, i+1, parent + String.valueOf(str[i]));
	}
	
	public static void main(String[] args) {
		String test = "abc";
		
		char[] str = test.toCharArray();
		printAllSubsquence(str, 0, "");
	}

}
