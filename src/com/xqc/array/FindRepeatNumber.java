package com.xqc.array;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,0,2,5,3};
		System.out.println(findRepeatNumber(nums));
		
	}
	//����һ��ʹ��hash��set��ֻ�ܴ�Ų��ظ������֣����û���ҵ�������-1
	private static int findRepeatNumber(int[] nums) {
		int res = -1;
		Set<Integer> set = new HashSet<Integer>();
		for(int num:nums) {
			//�����set��ע��ɹ����򷵻�true������ظ������ʧ�ܣ�����false
			if(!set.add(num)) {
				res = num;
				break;
			}
		}
		return res;
		
	}


}
