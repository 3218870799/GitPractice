package com.xqc.mapStruction;
/**
 * @ClassName:DFS.java
 * @Author qcxiao
 * @Date:2020��8��13������5:09:41
 * @Version:1.0
 * @Description:�����������
 */
public class DFS {
	
	private void dfs(boolean[] isVisited,int i) {
		//���ȷ��ʸýڵ�
		System.out.println(getValueByIndex(i)+"-->");
		//���ڵ�����Ϊ�Ѿ�����
		isVisited[i] = true;
		//���ҽڵ�i�ĵ�һ���ڽӽڵ�w
		int w = getFirstNeighbor(i);
		//˵����w
		while(w!=-1){
			if(!isVisited[w]){
				dfs(isVisited,w);
			}
			//���w�ڵ��Ѿ������ʹ�
			w = getNextNeighbor(i,w);
		}
	}

	private int getNextNeighbor(int i, int w) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getFirstNeighbor(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	private String getValueByIndex(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
