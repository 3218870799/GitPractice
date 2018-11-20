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
	        int l = 0, r = nums.length - 1, mid;
	        while (l <= r) {
	            mid = l + r >>> 1;
	            if (nums[mid] == target) return mid;
	            else if (nums[mid] >= nums[l]) {
	                if (nums[l] <= target && target < nums[mid]) r = mid - 1;
	                else l = mid + 1;
	            } else {
	                if (nums[mid] < target && target <= nums[r]) l = mid + 1;
	                else r = mid - 1;
	            }
	        }
	        return -1;
	    }
	}
	
}
