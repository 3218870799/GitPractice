package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode017 {
	
	public static void main(String[] args) {
		LeetCode017 leetcode = new LeetCode017();
		LeetCode017.Solution solution = leetcode.getSolution();
		System.out.println(solution.letterCombinations("23"));
	}

	public Solution getSolution(){
		return new Solution();
	}
		
	class Solution {
		
	    private final String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	    public List<String> letterCombinations(String digits) {
	        if (digits.length() == 0) return Collections.emptyList();
	        List<String> list = new ArrayList<>();
	        helper(list, digits, "");
	        return list;
	    }

	    private void helper(List<String> list, String digits, String ans) {
	        if (ans.length() == digits.length()) {
	            list.add(ans);
	            return;
	        }
	        for (char c : map[digits.charAt(ans.length()) - '2'].toCharArray()) {
	            helper(list, digits, ans + c);
	        }
	    }
	}
	
	
	class BestSolution {
	    //��ÿ�����ֵ����ݹ��һ�㣬ÿһ������ö��һ����ĸ���ݹ������һ�㣬��ɾ�������ĸ���ص���һ��״̬��ö����һ����ĸ���ݹ������־�ǵݹ���digits.lengtgh�㣬����ĸ��ϳ��ȵ���digits���ȣ��ݹ�����õ�һ�����ϵ���ĸ��ϣ�����list����������ѭ�����׵ݹ�
	    public List<String> letterCombinations(String digits) {
	        List<String> res = new ArrayList<>();
	        String oneRes = "";
	        if(digits.equals(""))return res;
	        String[] dict = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	        int[] digiInt = new int[digits.length()];
	        for(int i = 0;i<digits.length();i++)
	        {
	            digiInt[i]=digits.charAt(i)-'0';
	        }
	       
	        
	        combi(digiInt,0,dict,res,oneRes);
	        return res;
	    }
	    public void combi(int[] digits, int n,String[] dict, List<String> res,String oneRes)
	    {
	        if(n==digits.length)
	        {
	            res.add(oneRes);
	            return;
	        }
	        for(int j=0;j<dict[digits[n]].length();j++)
	        {
	            oneRes = oneRes + dict[digits[n]].charAt(j);
	            combi(digits,n+1,dict,res,oneRes);
	            oneRes = oneRes.substring(0,oneRes.length()-1);
	        }
	        
	    }
	}
	
}
