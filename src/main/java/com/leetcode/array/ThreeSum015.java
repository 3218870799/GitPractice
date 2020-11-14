package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @ClassName:����֮�͡���leetCode15��
 * @Author qcxiao
 * @Date:2020��8��29������10:31:57
 * @Version:1.0
 * @Description:
 */
public class ThreeSum015 {
	
	public static void main(String[] args) {
		ThreeSum015 leetcode = new ThreeSum015();
		ThreeSum015.Solution solution = leetcode.getSolution();
		
		int[] nums = {-1,-2,-3,4,1,3,0,3,-2,1,-2,2,-1,1,-5,4,-3};
		List result = solution.threeSum(nums);
		System.out.println(result);
		
	}
	private Solution getSolution() {
		return new Solution();
	}
	/**
	 * @Author qcxiao
	 * @Date:2020��8��29������10:35:17
	 * @Version:1.0
	 * @Description:�����ⷨ
	 */
	class Solution {
	    public List<List<Integer>> threeSum(int[] nums) {
	    	//������
	    	Arrays.sort(nums);
	    	int len = nums.length;
	    	List<List<Integer>> rev = new ArrayList<List<Integer>>();
	    	//������������д���
	        if (len < 3) return rev;
	    	if(nums[0]>0 || nums[len-1]<0 ) return rev;
	    	//����ѭ���ж�����֮���Ƿ�Ϊ0
	    	for(int i=0;i<len;i++){
	    		for(int j=i+1;j<len;j++){
	    			for(int k=j+1;k<len;k++){
	    				//�������0����������������һ�����������뵽���������
	    				if((nums[i]+nums[j]+nums[k])==0){
	    			    	List<Integer> temp =new ArrayList<Integer>();
	    					temp.add(nums[i]);
	    					temp.add(nums[j]);
	    					temp.add(nums[k]);
	    					rev.add(temp);
	    				}
	    				
	    			}
	    		}
	    	}
	    	//�����������ȥ���ظ���
	    	for(int i=0;i<rev.size()-1;){
	    		if(rev.get(i).equals(rev.get(i+1))){
	    			rev.remove(rev.get(i));
	    			i=0;
	    		}else{
	    			i++;
	    		}
	    	}
			return rev;
	        
	    }
	}
	
	class Solution02 {
	    public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> rev = new ArrayList<>();
	        //���⴦��
	        int len = nums.length;
	        if (len < 3) return rev;
	        //����
	        Arrays.sort(nums);
	        //����
	        int max = nums[len - 1];
	        if (max < 0) return rev;
	        
	        for (int i = 0; i < len - 2; ) {
	        	//�������������С�Ĵ����㣬�����ܺ�Ϊ��
	            if (nums[i] > 0) continue;
	            //�����С�������������ȻС���㣬�򲻿��ܣ���һ��
	            if (nums[i] + 2 * max < 0) {
	                while (nums[i] == nums[++i] && i < len - 2) ;
	                continue;
	            }
	            int left = i + 1, right = len - 1;
	            while (left < right) {
	                int sum = nums[i] + nums[left] + nums[right];
	                if (sum == 0) {
	                    rev.add(Arrays.asList(nums[i], nums[left], nums[right]));
	                    while (nums[left] == nums[++left] && left < right) ;
	                    while (nums[right] == nums[--right] && left < right) ;
	                } else if (sum < 0) ++left;
	                else --right;
	            }
	            while (nums[i] == nums[++i] && i < len - 2) ;
	        }
	        return rev;
	    }
	}

}
