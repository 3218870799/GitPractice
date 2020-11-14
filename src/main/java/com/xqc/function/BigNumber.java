package com.xqc.function;
/**
 * 
 * @author xqc
 * @data 2020��2��17��
 * Description:������ؼ���
 */
public class BigNumber {
	/**
	 * �����ӷ�
	 * @param a
	 * @param b
	 * @return �ӷ��ӹ��ַ���
	 */
	public static String BigNumberAdd(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		//���λ���ܽ�λ���λ����һ
		int maxL = Math.max(len1, len2)+1;
		int[] a1 = new int[maxL];
		int[] b1 = new int[maxL];
		//���ַ�������תΪ����
		for(int i =0;i<len1;i++){			
			a1[i] = a.toCharArray()[len1-1-i]-'0';
		}
		for(int j =0;j<len2;j++){
			b1[j] = b.toCharArray()[len2-1-j]-'0';
		}
		//����������ӣ���������a1��
		for(int k=0;k<maxL;k++){
			if(a1[k]+b1[k]>=10){
				int temp=a1[k]+b1[k];
				a1[k]=temp%10;
				a1[k+1]+=(temp/10);
			}else{
				a1[k]+=b1[k];
			}
		}
		StringBuffer c = new StringBuffer();
		//Ԥ���λλ��Ϊ0��ƴ�ӽ�c��������ƴ�Ӳ�����
		if(a1[maxL-1]!=0)
			c.append(a1[maxL-1]);
		for(int l=maxL-2;l>=0;l--)
			c.append(a1[l]);
		return c.toString();	
	}
	/**
	 * �����˷�
	 * @param a
	 * @param b
	 * @return
	 */
	public static String BigNumberMul(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		int[] a1 = new int[len1];
		int[] b1 = new int[len2];
		//���������飬len1λ����len2λ������Ϊlen1+len2λ
		int[] c1 = new int[len1+len2];
		//����ת����
		for(int i = 0;i<len1;i++)
			a1[i]=a.toCharArray()[len1-1-i]-'0';
		for(int i = 0;i<len2;i++)
			b1[i]=b.toCharArray()[len2-1-i]-'0';
		//����ʽ
		for(int i=0;i<len1;i++){
			for(int j=0;j<len2;j++)
				c1[i+j]+=a1[i]*b1[j];
		}
		//��ʽ���
		for(int i=0;i<len1+len2;i++){
			if(c1[i]>=10){
				c1[i+1]+=c1[i]/10;
				c1[i]%=10;
			}
		}
		//����ƴ��
		StringBuffer c = new StringBuffer();
		int i;
		//�ҵ���һ����Ϊ0��
		for(i =len1+len2-1;i>=0;i--){
			if(c1[i]!=0)break;
		}
		for(;i>=0;i--){
			c.append(c1[i]);
		}
		return c.toString();
	}
	/**
	 * ��������
	 * @param big
	 * @param small
	 * @return
	 */
	public static String BigNumberSub(String big, String small) {
		if(big==small)
			return "0";
		int len1 = big.length();
		int len2 = small.length();
		int[] bigArr = new int[len1];
		int[] smallArr = new int[len2];
		//���ַ�������תΪ����
		for(int i =0;i<len1;i++)		
			bigArr[i] = big.toCharArray()[len1-1-i]-'0';
		for(int i=0;i<len2;i++)
			smallArr[i] = small.toCharArray()[len2-1-i]-'0';
		//������ȥ�̵�
		for(int i=0;i<len2;i++){
			if(bigArr[i]<smallArr[i]){
				bigArr[i]=bigArr[i+10]-smallArr[i];
				bigArr[i+1]-=1;
			}else{
				bigArr[i]-=smallArr[i];
			}
		}
		//����ƴ��
		StringBuffer c = new StringBuffer();
		int i;
		//�ҵ���һ����Ϊ0��
		for(i =len1-1;i>=0;i--){
			if(bigArr[i]!=0)break;
		}
		for(;i>=0;i--){
			c.append(bigArr[i]);
		}
		return c.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(BigNumberAdd("9999919999","2632432"));
		System.out.println(BigNumberMul("9999","99999"));
		System.out.println(BigNumberSub("99999","90000"));
	
	}


}
