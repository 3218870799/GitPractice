package com.leetcode.string;

import java.util.*;

public class Offer48lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        //ά��һ������ջ������±�
        Deque<Integer> stack = new ArrayDeque<>();
        //ת���ַ�����
        char[] sArr = s.toCharArray();
        //ʹ��HashMapȥ��
        Map<Character, Integer> hasMap = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (!hasMap.containsKey(sArr[i])){
                stack.push(i);
            }else{
                while((!stack.isEmpty()) && stack.peek()<=i){
                    stack.pop();
                }
            }
            hasMap.put(sArr[i],i);
            maxLength = Math.max(maxLength,stack.size());
        }
        return maxLength;
    }
    public int lengthOfLongestSubstring2(String s) {
        //�洢 s[j] ��߾����������ͬ�ַ�Ϊ s[i] ���� s[i] = s[j]
        Map<Character,Integer> dic = new HashMap<>();
        int res = 0,tmp =0;
        for (int j = 1; j < s.length(); j++) {
            //��ȡ����i
            int i = dic.getOrDefault(s.charAt(j),-1);
            //����������
            dic.put(s.charAt(j),j);
            // dp[j - 1] -> dp[j]
            tmp = tmp < j - i ? tmp + 1 : j - i;
            //max(dp[j - 1], dp[j])
            res = Math.max(res,tmp);
        }
        return res;
    }

}
