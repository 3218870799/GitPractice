package com.leetcode.dp.medium;

/**
 * @ClassName PartitionEqualSubsetSum416
 * @Author Administrator
 * @Date 2020/12/22/022 15:27
 * @Description TODO
 */
public class PartitionEqualSubsetSum416 {

    public boolean canPartition(int[] nums){
        int len = nums.length;
        //�ȼ���sum
        int sum = 0;
        for (int num:nums) {
            sum+=num;
        }
        //���sum��������ֱ�ӷ���false
        if((sum & 1)==1){
            return false;
        }
        int target = sum/2;
        //��������ǰi���Ƿ����Ӽ�ʹ�ܺ�Ϊj
        boolean[][] dp = new boolean[len][target+1];
        //��ֵ��һ�У���һ��ֻ����������Ϊ0�ı���
        if(nums[0]<=target){
            dp[0][nums[0]] = true;
        }
        //�ӵڶ��п�ʼ���
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <=target ; j++) {
                //�����ǵ�ǰԪ�أ�ֱ�Ӵ���һ�г�����
                dp[i][j] = dp[i-1][j];
                //�����ǰֵǡ�õ��ڵ�ǰ����
                if (nums[i]==j){
                    dp[i][j] = true;
                    continue;
                }
                //�����ǰֵ�ϸ�С�ڵ�ǰ����
                if(nums[i]<j){
                    //������һ�е�ֵ��������һ���ұߵ�ֵ(���ǵ�ǰ�����������٣�������һ����������
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }

        }
    return dp[len -1][target];
    }
}
