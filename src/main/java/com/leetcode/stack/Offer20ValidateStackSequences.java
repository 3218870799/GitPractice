package com.leetcode.stack;

import java.util.Stack;

public class Offer20ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,1,2};
        System.out.printf("" + validateStackSequences(pushA,popA));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        //�����ջ���ջ���Ȳ���ͬ����ֱ�ӷ���false
        if (pushed.length != popped.length){
            return false;
        }
        //���Ϊ�գ�ֱ��Ϊ��
        if (pushed.length <1){
            return true;
        }
        //�ֽ���һ��Ԫ����ջ
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);
        int i =1;
        for (int j = 0; j < popped.length; j++) {
            //ȡ����ջ��Ԫ��
            int num = popped[j];
            //���ջ����Ԫ�ز����ڳ�ջԪ�أ�������ջ
            while(stack.peek() != num && i < pushed.length){
                stack.push(pushed[i++]);
            }
            if(stack.peek() == num){
                stack.pop();
                continue;
            }
            //һֱû�ҵ���ջ����ͬ��
            return false;
        }
        return true;
    }

}
