package com.xqc.classic;

import java.util.Arrays;

public class LongComString {
	
	/**
	 * �����������
	 * @param a
	 * @param b
	 * @return ��̬�滮����
	 * �滮��ά���飬�Ƚ��ַ���ͬ�������ͬ���i-1.j-1��ֵ��1
	 * �����ͬ����������Խǵ�����ֵ���ƹ���
	 */
	public static int LCS(String a,String b){
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m+1][n+1];

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				char c1 = a.charAt(i);
				char c2 = b.charAt(j);
				if(c1==c2){
					dp[i+1][j+1]=dp[i][j]+1;
				}else {
					dp[i+1][j+1]=Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		
		return dp[m][n];
	}
	/**
	 * �����������
	 * [10,9,2,5,7,101,18]�������������Ϊ2��3, 7, 18
	 * ʹ�ö�̬�滮
	 * @param nums
	 * @return
	 */
	public static int lengthOfLIS(int[] nums){
		
		int n = nums.length;
		//��ֹ��ĳһ��index�������������
		int[] dp = new int[n];
		
		int maxLen = 0;
		
		for(int i=0;i<n;i++){
			//һ����Ҳ������������
			int len =1;
			
			for(int j=0;j<i;j++){
				//
				if(nums[j]<nums[i]){
					len=Math.max(len, dp[j]+1);
				}
			}
			//��ֹ��i�������
			dp[i]=len;
			if(dp[i]>maxLen){
				maxLen=dp[i];
			}
		}
		return maxLen;
		
	}
	/**
	 * �����������
	 * ����¼���ĶԱ���ԭ�����м䣬���滻�����������򳤶ȼ�һ
	 * @param nums
	 * @return
	 */
	public static int lengthOfLISFunction2(int[] nums){
		int n = nums.length;
		int[] dp = new int[n];
		int len =0;
		for (int num : nums) {
			//���������ж�num��dp�е�ʲô�ط������±���٣���Χ��0��len
			int index = Arrays.binarySearch(dp, 0, len ,num);
			//<0��û�г��ֹ���ȡ��Ӧ�÷ŵĵط�
			//pos = 
			if(index<0){
				index = -(index+1);
			}
			//������м��ֱ�Ӹ���Ϊ�����
			dp[index] = num;
			//���Ӧ�ò����λ�������
			if(index==len){
				//����Ҫ��һ
				len++;
			}
			
		}
		return len;
	}
	
	
	
	
	public static void main(String arg[]){
		String a = "abcd";
		String b = "abcd";
		System.out.println(LCS(a,b));
		
	}

}
