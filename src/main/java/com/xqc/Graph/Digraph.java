package com.xqc.Graph;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName Digraph
 * @Author Administrator
 * @Date 2020/12/22/022 21:47
 * @Description TODO
 */
public class Digraph {
    //������Ŀ
    private final int V;
    //�ߵ���Ŀ
    private int E;
    //�ڽӱ�
    private Queue<Integer>[] adj;
    public Digraph(int V) {
        //��ʼ����������
        this.V = V;
        //��ʼ���ߵ�����
        this.E = 0;
        //��ʼ���ڽӱ�
        this.adj = new Queue[V];
        //��ʼ���ڽӱ��еĿն���
        for (int i = 0; i < adj.length; i++) {
            //adj[i] = new Queue<Integer>();
            adj[i] = new PriorityQueue<>();

        }
    }

    //��ȡ������Ŀ
    public int V() {
        return V;
    }

    //��ȡ�ߵ���Ŀ
    public int E() {
        return E;
    }

    //������ͼ�����һ���� v->w
    public void addEdge(int v, int w) {
        //��������ͼ�б�������ģ�v->w �ߣ�ֻ��Ҫ��w������v���ڽӱ��У�������Ҫ��v������w���ڽӱ���
        adj[v].add(w);
        //�ߵ���Ŀ����1
        E++;
    }

    //��ȡ��vָ���ı������ӵ����ж���
    public Queue<Integer> adj(int v) {
        return adj[v];
    }

    //��ͼ�ķ���ͼ
    private Digraph reverse() {
        //�����µ�����ͼ����
        Digraph r = new Digraph(V);
        //����0~V-1���ж���,�õ�ÿһ������v
        for (int v = 0; v < V; v++) {
            //�õ�ԭͼ�е�v�����Ӧ���ڽӱ�,ԭͼ�еı�Ϊ v->w,����ͼ�б�Ϊw->v;
            for (Integer w : adj(v)) {
                r.addEdge(w, v);
            }
        }
        return r;
    }
}
