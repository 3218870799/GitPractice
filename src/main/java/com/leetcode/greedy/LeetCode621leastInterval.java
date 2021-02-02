package com.leetcode.greedy;

import java.util.Arrays;

public class LeetCode621leastInterval {

    public int leastInterval(char[] tasks, int n) {
        int[] record = new int[26];
        for (char c :tasks){
            record[c -'A']++;
        }
        Arrays.sort(record);
        int max_n = record[25]-1;
        //�������Ĳ�Ψһ������ֻ���㲹�����ģ�Ȼ���ټ���������
        int space = max_n * n;
        for (int i = 24; i >=0 && record[i]>0 ; i--) {
            space-=Math.min(max_n,record[i]);
        }
        return space>0? tasks.length+space : tasks.length;
    }
}
