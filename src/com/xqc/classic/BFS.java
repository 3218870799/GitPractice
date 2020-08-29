package com.xqc.classic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/**
 * ������ȱ���
 * @author xqc
 * @data 2020��2��17��
 * Description:
 */
public class BFS {
	
	private void bfs1(boolean[] isVisited,int i) {
		//��ʾ���е�ͷ�ڵ��Ӧ���±�
		int u;
		//�ڽӽڵ�w
		int w;
		//���У���¼�ڵ���ʵ�˳��
		LinkedList queue = new LinkedList();
		//���ʽڵ㣬����ڵ���Ϣ
		System.out.println(i+"--->");
		//���Ϊ�ѷ���
		isVisited[i] = true;
		//���ڵ���뵽����
		queue.addLast(i);
		while(!queue.isEmpty()){
			//ȡ�����е�ͷ�ڵ���±�
			u = (Integer)queue.removeFirst();
			//�õ���һ���ڽӽڵ���±�w
			w = getFirstNeighbor(u);
			//�ҵ�
			while(w!= -1){
				//�Ƿ񱻷��ʹ�
				if(!isVisited[w]){
					System.out.println(w+" ����>");
					//���Ϊ�Ѿ�����
					isVisited[w] = true;
					//���
					queue.addLast(w);
				}
				//��uΪǰ���㣬�ҵ�w�������һ���ڽӵ�
				w = getNextNeighbor(u,w);
			}
		}
		
	}
	
	
	
	
    private int getNextNeighbor(int u, int w) {
		// TODO Auto-generated method stub
		return 0;
	}




	private int getFirstNeighbor(int u) {
		// TODO Auto-generated method stub
		return 0;
	}




	/**
     * ��Žڵ��ϵ��hashtable��ͼ���ڽӱ����߱���ʾ
     * @param graph
     * @param dist ����s�����ߵľ���
     * @param s ����
     * Description:ʹ�ö���ʵ�֣�����һ�����뵽���У�
     * �����в�Ϊ�գ�ȡ��һ���ڵ㣬����δ���ʹ����ӽڵ���뵽������
     * ֱ������Ϊ��
     * 
     */
    public static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist, Character s) {
        //��������
        Queue<Character> q = new LinkedList<>();
        //������ʼ�ڵ�
        Character start = s;
        //��ʼ�ڵ�ŵ��������
        dist.put(start, 0);
        ((LinkedList<Character>) q).add(start);
        //�����в�Ϊ��ʱ
        while (q != null) {
            //ȡ������Ԫ��
            Character poll = q.poll();
            if(poll == null){
                break;
            }
            Integer distance = dist.get(poll);
            System.out.println("�ڵ�" + poll + "����ʼ�ڵ�" + start + "�ľ���Ϊ" + distance);
            distance++;
            //�����ýڵ���ڽӱ��е�ÿһ���ڵ㣬��δ���ʹ������ڽӽڵ����
            for (Character c : graph.get(poll)) {
                //δ���ʹ����ڵ����û�м��뵽dist��hashmap��
                if (!dist.containsKey(c)) {
                    dist.put(c, distance);
                    //������Ϊ��ʱ��ʹ��add�����ᱨ����offer�����᷵��false��
                    //��ΪListʹ��ʱ,һ�����add / get������ ѹ��/��ȡ����
                    //��ΪQueueʹ��ʱ,�Ż���� offer/poll/take�ȷ�����Ϊ�������ʱ,
                    //offer�ȷ��������˵û��ʲô������Щ����������֧�ֶ���Ӧ�õġ�
                    q.offer(c);
                   
                }
            }
        }

    }
    
    public static void main(String[] args) {
        HashMap<Character, LinkedList<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> dist = new HashMap<>();

        // s������ڽӱ�
        LinkedList<Character> list_s = new LinkedList<Character>();

        list_s.add('A');

        list_s.add('B');

        LinkedList<Character> list_a = new LinkedList<Character>();

        list_a.add('C');

        list_a.add('D');

        LinkedList<Character> list_b = new LinkedList<Character>();

        list_b.add('D');

        list_b.add('E');

        LinkedList<Character> list_c = new LinkedList<Character>();

        list_c.add('E');

        LinkedList<Character> list_d = new LinkedList<Character>();

        list_c.add('E');


        //����ͼ

        graph.put('S', list_s);

        graph.put('A', list_a);

        graph.put('B', list_b);

        graph.put('C', list_c);

        graph.put('D', list_d);

        graph.put('E', new LinkedList<Character>());


        //����

       BFS.bfs(graph, dist, 'S');

    }

}




