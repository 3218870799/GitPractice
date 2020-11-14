package com.leetcode.array;

public class LeetCode033 {
	public static void main(String[] args) {
		LeetCode033 leetcode = new LeetCode033();
		LeetCode033.Solution solution = leetcode.getSolution();
		int[] nums = {1,2,3,4,0};
		System.out.println(solution.search(nums, 0));

	}
	
	public Solution getSolution(){
		return new Solution();
	}
	/**
	 * λ����:�������󲢲��ı�ԭ����
	 * 	���� 1 λ *2������ 2 λ *4������ 3 λ *8������������
	 * 	���� 1 λ /2 ,���� 2 λ ��4 ��������λ /8������������
	 *
	 */
	class Solution {
	    public int search(int[] nums, int target) {
	    	int left =0,right = nums.length-1,mid;
	    	while(left<=right){
		    	mid=left + right>>>1;
	    		if(nums[mid]==target)
	    			return mid;
	    		else if(nums[mid]>=nums[left]){
	    			if(nums[left]<=target&&nums[mid]>=target)
	    				right=mid-1;
	    			else
	    				left = mid+1;
	    		}else{
	    			if(target<=nums[right]&&target>nums[mid])
	    				left = mid +1;
	    			else
	    				right = mid-1;
	    		}
	    	}
	    	return -1;
	    }
	}
}
