package com.xqc.function;

import java.util.Scanner;

/**
 * 
 * @author xqc
 * @data 2020��2��18��
 * Description:
 * ���鼯
 * 1:�ж��������ǲ�����һ������
 * 2:����������뵽һ������
 */
public class DisJointSet {
	static int maxn = 10000+10;
	//��������
	static int[] parent;
	//rank��¼ÿ�����ĸ߶�
	static int[] rank ;
	/**
	 * ���鼯��ʼ��
	 */
	public static void init(){
		parent = new int[maxn];
		rank =new int[maxn];
		for(int i = 0;i<maxn;i++){
			//��ʼ�����ڵ�Ϊ�Լ�
			parent[i]=i;
		    rank[i]=1;
		}
	}
	/**
	 * ���Ҹ��ڵ㲢����·��ѹ��
	 * @param x
	 * @return
	 */
	public int findRoot(int x){
		//return parent[x] == x ? x : ((int)parent[x]=findRoot(parent[x]));
		while(parent[x]!=x){
			parent[x]=parent[parent[x]];//·��ѹ��
			x=parent[x];
		}
		return x;
	}
	//�ж�����ԭ���Ƿ���ͬһ��������
	public boolean isSameSet(int x,int y){
		return findRoot(x)==findRoot(y);
	}
	//�ϲ���������
	public void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        //����������һ�����ϣ�ֱ���˳�
        if (xRoot == yRoot) {
            return;
        }
        //x�����ߣ�y�ĸ��ӵ�x�ĸ��ϣ�yRoot�ĸ�ָ��ָ��xRoot
        if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else if (rank[yRoot] > rank[xRoot]) {
            parent[xRoot] = yRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] ++;
        }
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.next();
		System.out.println(str);
		
		
	}

}
