package com.xqc.function;

public class LineSieve {
	
	public static int maxn = 1000;
	/**
	 * ����ɸ����O(1)�ĸ��Ӷ�ɸ��1~N���е�����
	 * @param n
	 * f(x) xΪ����ʱf(x) = true
	 *      ����f(x) = false
	 */
	private static void primeSieve(int n) {
		// TODO Auto-generated method stub
		boolean[] vis = new boolean[maxn];
		int[] prime = new int[maxn];
		int cnt=0;
		for(int i=2;i<maxn;i++){
			//��������û�б��κ�����ǹ����������������
			//����������prime��
			if(!vis[i]) prime[cnt++]=i;
			//ɸi�ı���һ����������
			//for(int j=2*i;j<maxn;j+=i)vis[j]=true
			//ɸi������������Ϊ��������һ��Ҳ�ᱻ������ɸ
			for(int j=0;j<cnt&&i*prime[j]<maxn;j++){
				//���䱶�����Ϊtrue
				vis[i*prime[j]]=true;
				//����С�����Ӳ����ˣ�����ɸ�ˣ���Ϊ��һ���ᱻ���ɸ
			    if(i%prime[j]==0)break;
			}
			
		}
		for (int j : prime) {
			System.out.println(prime[j]);
			
		}
	}
	
	
	/**
	 * ŷ���������ṩ1��N����N���ʵ���
	 */
	private static void eulerEqua() {
		// TODO Auto-generated method stub
		int[] phi = new int[maxn];
		
		boolean[] vis = new boolean[maxn];
		int[] prime = new int[maxn];
		int cnt=0;
		
		for(int i=2;i<=maxn;i++){
			if(!vis[i]){
				prime[cnt++]=i;
				phi[i]=i-1;
			}
			for(int j=0;j<cnt&&i*prime[j]<=maxn;j++){
				vis[i*prime[j]]=true;
				if(i%prime[j]==0){
					phi[i*prime[j]]=phi[i]*prime[j];
					break;
				}else{
					
				}
			}
		}
		
		
	}
	
	/**
	 * Ī����˹����
	 * �����ӵ�����һ������ָ������1��f(x)=0,����f(x)=(-1)^n������n��������
	 * Ψһ�ֽⶨ��
	 * x=p1^k1*p2^k2����*pn^kn
	 */
	public static void main(String[] args) {
		int n =10;
		primeSieve(n);
		eulerEqua();
	}

	/**
	 * �������׾��
	 * id f(x) =x
	 * I  f(x) =1
	 * e  f(x) = x==1 ?1:0  Ī����˹����
	 */




}
