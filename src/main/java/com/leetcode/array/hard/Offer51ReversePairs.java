package com.leetcode.array.hard;

public class Offer51ReversePairs {

    public int reversePairs(int[] nums) {
        //�������鳤��
        int len = nums.length;

        if (len < 2) {
            return 0;
        }
        //��ԭʼ������п�������Ϊ��Ҫ�޸�ԭʼ����
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        //�����������ڹ鲢��������
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] ��������Ը�����������
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        //�ݹ���ֹ����
        if (left == right) {
            return 0;
        }
        //��left + right�ܴ�ʱ���׷�����������ֲ��ҵ��͵Ĵ���
        int mid = left + (right - left) / 2;
        //�ֱ�����������߽��м���
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        //����ϲ�ʱ�������Ե�����
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        //���ؽ�������Ϊ��ߵ�+�ұߵ� + �ϲ�ʱ��
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] ����nums[mid + 1..right] ����
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        //�ֱ�ָ����������Եĵ�һ��Ԫ��
        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
