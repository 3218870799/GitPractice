package com.leetcode.array.medium;

public class LeetCode189Rotate {

    public void rotate(int[] nums, int k) {
        //��ֹk�Ķ������鳤�ȣ���ת�ľͲ�ֹһȦ
        k %= nums.length;
        //�ֽ�����������ת
        reverseArray(nums,0,nums.length-1);
        //�ٽ�ǰk��������ת
        reverseArray(nums,0,k-1);
        //�ٽ�����Ľ�����ת
        reverseArray(nums,k,nums.length);
    }

    private void reverseArray(int[] nums, int start, int end) {
        while (start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }


}
