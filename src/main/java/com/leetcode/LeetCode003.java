package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode003 {
	/*
	 * Leetcode3
	 * ����һ���ַ������ҳ��������ظ��ַ�����Ӵ��ĳ��ȡ�

		ʾ�� 1:
		
		����: "abcabcbb"
		���: 3 
		����: ���ظ��ַ�����Ӵ��� "abc"���䳤��Ϊ 3��
		ʾ�� 2:
		
		����: "bbbbb"
		���: 1
		����: ���ظ��ַ�����Ӵ��� "b"���䳤��Ϊ 1��
		ʾ�� 3:
		
		����: "pwwkew"
		���: 3
		����: ���ظ��ַ�����Ӵ��� "wke"���䳤��Ϊ 3��
		     ��ע�⣬�𰸱�����һ���Ӵ���"pwke" ��һ�������� �������Ӵ���
	 */
	
	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	    	Set<Character> set = new HashSet<Character>();
	    	int n = s.length();
	    	int i=0,j=0,maxlength=0;
	    	while(i<n&&j<n){
	    		if(!set.contains(s.charAt(j))){
	    			set.add(s.charAt(j++));
	    			maxlength=Math.max(maxlength, j-i);
	    		}else {
	    			//��ԭ��setǰ
	    			set.remove(s.charAt(i++));
				}
	    	}
			return maxlength;
	    }
	}
	/**
	 * 
	 * Best Solution
	 *
	 */
	class BestSolution {
	    public int lengthOfLongestSubstring(String s) {
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	        
	    }
	}

}
