package com.leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56Merge {
    public static void main(String[] args) {

    }


    public int[][] merge(int[][] intervals) {
        //����һ����ά���飬�������û�У�ֱ�ӷ���
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0],end = intervals[i][1];
            //����������Ϊ�գ����������������λ��С��������Ŀ�ʼλ�ã������кϲ���ֱ�ӷ�������
            if (result.size()==0 || result.get(result.size()-1)[1] < start){
                result.add(new int[]{start,end});
            }else{
                //���򣬺ϲ���������,��ֹ����[[1,4],[2,3]]���������
                result.get(result.size()-1)[1] = Math.max(result.get(result.size() - 1)[1], end);
            }
        }
        return result.toArray(new int[result.size()][]);
    }



}
