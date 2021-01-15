package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode739DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        //
        Deque<Integer> stack = new ArrayDeque<>();
        //����������
        int[] res = new int[T.length];
        //����ÿ���¶�
        for (int i = 0; i < T.length; i++) {
            //�������¶ȴ���ջ���¶ȣ�˵������δ�����գ�ջ��һֱ��ջ�������
            while (!stack.isEmpty() && T[stack.peek()] < T[i]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
