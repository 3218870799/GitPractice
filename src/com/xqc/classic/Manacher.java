package com.xqc.classic;

/**
 * 
 * @author xqc
 * @data 2020��3��21��
 * Description:Manacher�㷨����Ҫ�������ҵ��ַ����е�������Ӵ�
 * �����⣺���м䣬�ж�i+1��i-1���Ƿ���ȣ���ż�������#����ȫ�������
 * [L          x= 2*id -i        id        i          R]
 * [��߽�                i����id�ĶԳƵ�x      �е�id     i��            �ұ߽�]
 * ���һ����xΪ���ĵĻ����Ӵ�������id�ķ�Χ��
 * ���������xΪ���ĵĻ����Ӵ�����id�Ļ����Ӵ�����߽�
 * 
 */
public class Manacher {
	
	public static void main(String[] args) {
		String str = "abc1234321ab";
		System.out.println(maxLcpsLength(str));
	}
	
	public static char[] manacharString(String str){
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length()*2+1];
		int index = 0;
		for(int i = 0;i!=res.length;i++){
			res[i] = (i&1)==0?'#':charArr[index++];
		}
		return res;
	}
	
	
	public static int maxLcpsLength(String str){
		if(str == null|| str.length()==0)
			return 0;
		char[] charArr = manacharString(str);
		int[] pArr = new int[charArr.length];
		int C = -1;
		int R = -1;
		int max = Integer.MAX_VALUE;
		for(int i = 0;i!=charArr.length;i++){
			pArr[i] = R>i?Math.min(pArr[2*C-i], R-i) : 1;
			while(i+pArr[i]<charArr.length && i-pArr[i]>-1){
				if(charArr[i+pArr[i]]==charArr[i-pArr[i]])
					pArr[i]++;
				else{
					break;
				}
			}
			if(i+pArr[i]>R){
				R = i + pArr[i];
				C = i;
			}
			max = Math.max(max, pArr[i]);
		}
		
		return max-1;
		
	}

}
