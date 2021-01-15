package com.leetcode.stack;

import java.util.Stack;

public class LeetCode42Trap {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        //����������޷��γɵ���ʱ
        if (height.length < 3){
            return 0;
        }
        //ѭ����������
        for (int i = 0; i < height.length; i++) {
            //ά������ջ������ǰԪ�ش���ջ��Ԫ��ʱ
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                //ջ��Ԫ�س�ջ
                int popnum = stack.pop();
                //��ͬԪ���������1,1
                while (!stack.isEmpty() && (height[i] == height[stack.peek()])){
                    stack.pop();
                }
                //����ò�ˮ�ĵ�λ
                if (!stack.isEmpty()){
                    //��ջ��Ԫ�أ�����߽�߶�
                    int temp = height[stack.peek()];
                    //��
                    int high = Math.min(temp-height[popnum],height[i]-height[popnum]);
                    //��
                    int wid = i - stack.peek() -1;
                    water += high * wid;
                }
            }
            //��������ջ��������һ��
        }
        return water;
    }

}
