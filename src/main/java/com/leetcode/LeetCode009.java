package com.leetcode;


public class LeetCode009 {
	
	public static void main(String[] args) {
		LeetCode009 leetcode = new LeetCode009();
		LeetCode009.Solution solution = leetcode.getSolution();
		boolean result = solution.isPalindrome(2);
		System.out.println(result);
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public boolean isPalindrome(int x) {
	    	if(x<0|| (x != 0 && x % 10 == 0)) return false;
	    	
	    	int[] arr = new int[32];
	    	int i=0;
	    	while(x!=0){
	    		int lastbit = x%10;
	    		x/=10;
	    		arr[i] = lastbit;
	    		i++;
	    	}
	    	for(int j=0;j<i/2;j++){
	    		if(arr[j]!=arr[i-j-1])
	    			return false;
	    	}
			return true;
	        
	    }
	}
	/**
	 * ˼·��
	 * 
	 * 		����x�ĺ�һ����з�ת������ת�����ǰ�벿�������Ϊ����
	 * 
	 *
	 */
	class BestSolution {
	    public boolean isPalindrome(int x) {
	        if (x < 0 || (x != 0 && x % 10 == 0)) { //x��10�ı���һ�����ǻ��Ĵ�
	            return false;
	        }
	        int s = 0;
	        while (s <= x) {
	            s = s * 10 + x % 10;
	            if (s == x || s == x / 10) { //�ֱ���������������������ż�������
	                return true;
	            }
	            x /= 10;
	        }
	        return false;
	    }
	}

}
