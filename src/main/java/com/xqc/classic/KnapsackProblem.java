package com.xqc.classic;

public class KnapsackProblem {
	/**
	 * 01b��������,ÿ����Ʒֻ��һ������������Ϊn���ڱ�������ôװ����ʹװ�Ķ�����ֵ���
	 * @param weight
	 * @param value
	 * @param n
	 * @return 
	 *        0  1  2  3  4  5  6  7  8  9  10   ����
	 *        ������������������������������������������������������������������������
	 *      1|
	 *      2|
	 *      dp[i][j] ��������Ϊjʱ������ѡ��ǰi����Ʒ���ﵽ���ļ�ֵ
	 *        ��ʽ1:ѡ���i����Ʒ dp[i-1][j-w[i]]+value[i],�����=��i����Ʒ�ļ�ֵ+ʣ������ѡ��ǰi-1����Ʒ���ܴﵽ�����ֵ
	 *        ��ʽ2����ѡ���i����Ʒdp[i-1][j]�����=����Ϊjʱѡ��ǰi-1����Ʒ���ܴﵽ�����ֵ
	 *   �ʣ�����dp[i][j]=MAX(dp[i-1][j-w[i]]+value[i],dp[i-1][j]);
	 */
	private static int KnapsackProblem(int[] weight, int[] value, int n) {
		//m��ʾ��Ʒ������
		int m = weight.length;
		int[][] dp = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(j>=weight[i]){
					dp[i][j]=Math.max(dp[i-1][j-weight[i]]+value[i],dp[i-1][j] );
				}else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[m][n];
		
	}
	
	
	public static void main(String[] args) {
		int[] weight = {2,2,6,5,4};
		int[] value = {6,3,5,4,6};
		System.out.println(KnapsackProblem(weight,value,10));

	}



}
