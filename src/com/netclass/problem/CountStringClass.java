package com.netclass.problem;

import java.util.Scanner;

/**
 * 
 * @author xqc
 * @data 2020��3��23��
 * Description:����һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ����� 
 */
public class CountStringClass {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		char[] ch  = input.nextLine().toCharArray();
		
        int abccount=0;
        int spacecount=0;
        int numcount=0;
        int othercount=0;

		for (int i = 0; i < ch.length; i++) {
			//�ж��ǲ�����ĸ
	           if(Character.isLetter(ch[i])) {
	                abccount++;
	                //�ж��ǲ�������
	            }else if(Character.isDigit(ch[i])) {
	                numcount++;
	                //�ж��ǲ��ǿո�
	            }else if(Character.isSpaceChar(ch[i])){
	                spacecount++;
	            }else{
	                othercount++;
	            }
	    }
	        System.out.println(abccount);
	        System.out.println(spacecount);
	        System.out.println(numcount);
	        System.out.println(othercount);
	}

}
