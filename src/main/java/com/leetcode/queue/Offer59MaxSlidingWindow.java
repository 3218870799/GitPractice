package com.leetcode.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Offer59MaxSlidingWindow {
    public static void main(String[] args) {


    }

    //�����ⷨ��ֱ�ӱ������㴰���ڵ����ֵ��Ȼ�󱣴浽������
    public ArrayList<Integer> maxSlidingWindowFunc1(int[] nums, int k) {
        //���屣��������
        ArrayList<Integer> list = new ArrayList<>();
        //�����ڴ�СΪ�գ����򴰿ڴ�С�������鳤��
        if (k < 1 || nums.length < k) {
            return list;
        }
        int left = 0;
        int right = k - 1;
        //�����ƶ�
        while (right < nums.length) {
            //���㵱ǰ�������ֵ
            int val = calcMax(left, right, nums);
            list.add(val);
            left++;
            right++;
        }
        return list;
    }

    public int calcMax(int left, int right, int[] nums) {
        int max = nums[left];
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
        	return new int[0];
		}
        //�������У�������ʵ��
        Deque<Integer> deque = new LinkedList<>();
        //���巵�ؽ������
        int[] res = new int[nums.length - k + 1];
		//res������±�
		int index = 0;
		//δ�γɴ�������
        for (int i = 0; i < k; i++) {
            //���в�Ϊ��ʱ����ǰֵ�����β��ֵ�Ƚϣ�������ڣ�ɾ������β��ֵ
            //һֱѭ��ɾ���������е�ֵ�����ڵ�ǰֵ������ɾ������Ϊ��
            while (!deque.isEmpty() && nums[i] > deque.peekLast()){
            	// [ 3,2 ]
            	deque.removeLast();
			}
            //ִ���������ѭ���󣬶�����ҪôΪ�գ�Ҫôֵ���ȵ�ǰֵ��Ȼ��Ͱѵ�ǰֵ��ӵ�������
            deque.addLast(nums[i]);
        }
        //����������γɺ󣬰Ѷ�����λֵ��ӵ����������
        //��Ϊ�����γɺ󣬾���Ҫ�Ѷ�����λ��ӵ������У��������ѭ����ֱ��������һ���ģ�������Ҫ����ֱ�����
		res[index++] = deque.peekFirst();
        //���������γɣ�i��ʱΪ�Ҳര��
        for (int i = k; i < nums.length; i++) {
            //i-k���Ѿ����������ˣ������λ����nums[i-k]����ô˵����ʱ��λֵ�Ѿ������������ˣ���Ҫɾ��
			//���ֵ���õ���Ҫɾ�����Ǹ�Ԫ��
            if (deque.peekFirst() == nums[i - k]) {
            	deque.removeFirst();
			}
            //ɾ�������бȵ�ǰֵ���ֵ
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
            	deque.removeLast();
			}
            //�ѵ�ǰֵ��ӵ�������
            deque.addLast(nums[i]);
            //�Ѷ��е���λֵ��ӵ�arr������
            res[index++] = deque.peekFirst();
        }
        return res;
    }


}
