package com.xqc.classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * @author xqc
 * @data 2020��2��22��
 * Description:����ͼ�����ж��㲢��Ȩֵ֮����С
 */
class MinSpanTree {
	/**
	 * 
	 * @author xqc
	 * @data 2020��2��22��
	 * Description:
	 */
	static class Edge{
		//Ȩ��
		int weight;
		//��������
		int x;
		int y;
		public Edge(int w,int a,int b){
			weight=w;
			x=a;
			y=b;
		}
	}
	/**
	 * ���鼯
	 * @author xqc
	 * @data 2020��2��22��
	 * Description:
	 */
	static class DSU{
		int[] root;//���׽ڵ�
		int[] size;//
		public DSU(int n){
			root = new int[n];
			size = new int[n];
			//��ʼ�������ڵ�ָ���Լ�
			for(int i =0;i<n;i++){
				root[i]=i;
			}
			//һ��ʼÿ����ͨ��������1
			Arrays.fill(size, 1);
			
		}
		public int findRoot(int x){
			if(root[x]!=x){
				root[x]=findRoot(root[x]);
			}
			return root[x];
		}
		public void union(int x,int y){
			int rootX = findRoot(x);
			int rootY = findRoot(y);
			if(rootX==rootY)return;
			//���rootX��С���Ͱ�rootX�ĸ�����rootY
			if(size[rootX]<size[rootY]){
				root[rootX]=rootY;
			}else{
				root[rootY] = rootX;
			}
		}
		
	}
	
	static class Pair{
		int weight;
		int y;
		public Pair(int w,int b){
			weight = w;
			y = b;
		}
	}
	
	
	public static void main(String[] args) {
/*#################################		
		Scanner input = new Scanner(System.in);
		//n������
		int n = input.nextInt();
		//m����
		int m = input.nextInt();
		Edge[] edges = new Edge[m];
		//����ÿ���ߣ��õ�һ��ͼ
		for(int i=0;i<m;i++){
			int a = input.nextInt();
			int b = input.nextInt();
			int w = input.nextInt();
			edges[i] = new Edge(w,a,b);
		}
		

		//��lamda���ʽ���䰴��weight����
		Arrays.sort(edges,(a,b)->a.weight-b.weight);

		int minmumCost = Kruskal(edges);
		
		System.out.println(minmumCost);
		
##########################*/
		Scanner input = new Scanner(System.in);
		int nodes = input.nextInt();
		int edges = input.nextInt();
		//���ڽӱ��ʾͼ�����㣬�������ڽڵ�ľ���list
		Map<Integer ,List<Pair>> g = new HashMap<>();
		
		for(int i=0;i<edges;i++){
			int a=input.nextInt();
			int b=input.nextInt();
			int w = input.nextInt();
			//���û�м����Ͱ���put
			g.putIfAbsent(a, new ArrayList<>());
			g.putIfAbsent(b, new ArrayList<>());
			
			g.get(a).add(new Pair(w,b));
			g.get(b).add(new Pair(w,b));
		}
		int minimumCost = Prim(1,g);
		System.out.println(minimumCost);
	}
	/**
	 * С��չ��̰��ѡȡδ�ڼ�������̵ı�
	 * @return 
	 */
	private static int Prim(int x,Map<Integer,List<Pair>> g) {
		//��ʾ�Ƿ���ʹ�
		boolean[] visited = new boolean[10005];
		
		PriorityQueue<Pair> heap = new PriorityQueue<>((a,b)->a.weight-b.weight);
		heap.offer(new Pair(0,x));
		
		int minimumCost=0;
		while(!heap.isEmpty()){
			Pair p = heap.poll();
			//��������һ����
			x=p.y;
			//������ʹ��Ͳ��ٲ�����
			if(visited[x]) continue;
			//��־�Ѿ�����
			visited[x] = true;
			minimumCost+=p.weight;
			for(int i=0;i<g.get(x).size();i++){
				if(!visited[g.get(x).get(i).y]){
					heap.offer(g.get(x).get(i));
				}
			}
		}
		return minimumCost;
	}
	/**
	 * �����ϣ�����С�ı߼��뼯��ʹ�䲢�����γɻ�
	 * ʹ�ò��鼯�ж��䲻�ܳɻ�
	 * ����������
	 * 4 5
	 * 1 2 7
	 * 1 4 6
	 * 4 2 9
	 * 4 3 8
	 * 2 3 6
	 */
	private static int Kruskal(Edge[] edges) {
		//ʹ�ò��鼯
		DSU dsu = new DSU(10005);
		
		int minimumCost = 0;
		for (Edge edge : edges) {
			int x = edge.x;
			int y = edge.y;
			//���������һ����ͨ����
			if(dsu.findRoot(x)!=dsu.findRoot(y)){
				minimumCost+=edge.weight;
				dsu.union(x,y);
			}
		}	
		return minimumCost;
		
	}

}
