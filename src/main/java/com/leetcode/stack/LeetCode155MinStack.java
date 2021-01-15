package com.leetcode.stack;

import java.util.Stack;

public class LeetCode155MinStack {
    //����Ԫ��ջ
    private Stack<Integer> dataStack;
    //���帨��ջ
    private Stack<Integer> minStack;


    /** initialize your data structure here. */
    public LeetCode155MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }
    public int top() {
        return dataStack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }

}
