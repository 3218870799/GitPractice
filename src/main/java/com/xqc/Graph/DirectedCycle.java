package com.xqc.Graph;

/**
 * @ClassName DirectedCycle
 * @Author Administrator
 * @Date 2020/12/22/022 21:45
 * @Description TODO
 */
public class DirectedCycle {
    //���������㣬ֵ��ʾ��ǰ�����Ƿ��Ѿ�������
    private boolean[] marked;
    //��¼ͼ���Ƿ��л�
    private boolean hasCycle;
    //���������㣬ʹ��ջ��˼�룬��¼��ǰ������û���Ѿ�������������������·����
    private boolean[] onStack;
    //����һ����⻷���󣬼��ͼG���Ƿ��л�
    public DirectedCycle(Digraph G){
        //����һ����ͼ�Ķ�����һ����С��marked����
        marked = new boolean[G.V()];
        //����һ����ͼ�Ķ�����һ����С��onStack����
        onStack = new boolean[G.V()];
        //Ĭ��û�л�
        this.hasCycle=false;
        //��������ͼ�е�ÿһ������
        for (int v = 0; v <G.V(); v++) {
            //�����ǰ����û����������������
            if (!marked[v]){
                dfs(G,v);
            }
        }
    }
    //��������������������ͼG���Ƿ��л�
    private void dfs(Digraph G, int v){
        //�ѵ�ǰ������Ϊ������
        marked[v]=true;
        //�õ�ǰ�����ջ
        onStack[v]=true;
        //����v������ڽӱ��õ�ÿһ������w
        for (Integer w : G.adj(v)){
            //�����ǰ����wû�б�����������ݹ�������w������ͨ����������
            if (!marked[w]){
                dfs(G,w);
            }
            //�������w�Ѿ�������������鿴����w�Ƿ���ջ�У�����ڣ���֤��ͼ���л����޸�hasCycle��ǣ�����ѭ��
            if (onStack[w]){
                hasCycle=true;
                return;
            }
        }
        //��ǰ�����Ѿ�������ϣ��õ�ǰ�����ջ
        onStack[v]=false;
    }
    //�ж�w������s�����Ƿ���ͨ
    public boolean hasCycle(){
        return hasCycle;
    }

}
