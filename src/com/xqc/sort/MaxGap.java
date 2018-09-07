package com.xqc.sort;

public class MaxGap {

	public static int maxGap(int[] nums) {
		//�������Ϊ�ջ���Ϊһû������ֵ
		if (nums == null || nums.length < 2) {
			return 0;
		}
		
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		//�����������飬�ҵ���Сֵ�����ֵ
		for (int i = 0; i < len; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		//��С�������������ȫ��һ����
		if (min == max) {
			return 0;
		}
		//����Ͱ�Ƿ���������
		boolean[] hasNum = new boolean[len + 1];
		//����Ͱ�����ֵ
		int[] maxs = new int[len + 1];
		//����Ͱ����Сֵ
		int[] mins = new int[len + 1];
		
		int bid = 0;
		for (int i = 0; i < len; i++) {
			//��Ͱ������Ͱ��Ϣ
			bid = bucket(nums[i], len, min, max);
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
			hasNum[bid] = true;
		}
		int res = 0;
		int lastMax = maxs[0];
		int i = 1;
		//�Ҹ��ǿ�Ͱ����ߵķǿ�Ͱ���õ�ǰ��С��ȥ������Ϊ��ֵ
		for (; i <= len; i++) {
			if (hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}

	public static int bucket(long num, long len, long min, long max) {
		return (int) ((num - min) * len / (max - min));
	}



}
