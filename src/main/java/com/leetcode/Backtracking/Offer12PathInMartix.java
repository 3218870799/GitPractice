package com.leetcode.Backtracking;

public class Offer12PathInMartix {
    public static void main(String[] args) {

        //bool result = exist()
    }
    public boolean exist(char[][] board, String word) {
        //�жϾ�����״
        if(board.length==0) {
            return false;
        }
        //�����ά�������Ƿ��Ѿ�������
        boolean[][] vis = new boolean[board.length][board[0].length];
        //��ʼ��ȫΪfalse
        //����ÿһ����Ѱ�ҵ�һ���ַ�
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //�Ե�һ���ַ�Ϊ�����ȱ������ҵ�һ���ͷ���
                //
                if (dfs(board,word,i,j,vis,0)){
                    return true;
                }
            }
        }
        //һֱû�У�����false
        return false;
    }
    //id����������Ҫ����ַ����ĵڼ���λ����ƥ�䵽
    public boolean dfs(char[][] board, String word,int i,int j,boolean[][] vis,int id) {
        //���ݺ������ɹ��˳���ʧ���˳�
        //�ȿ���ʧ���˳�
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || vis[i][j] == true){
            return false;
        }
        if (board[i][j] != word.charAt(id)){
            return false;
        }
        //�ɹ��˳�
        //word��������
        if (id == word.length() -1){
            return true;
        }
        //��������ڻ�û�˳����ʹӸ�λ�ÿ�ʼ����
        vis[i][j] = true;
        boolean flag = dfs(board,word,i+1,j,vis,id+1)
                    || dfs(board,word,i-1,j,vis,id+1)
                    || dfs(board,word,i,j+1,vis,id+1)
                    || dfs(board,word,i,j-1,vis,id+1);
        //ÿ�λ�����֮���ٸĻ���
        vis[i][j] = false;
        return flag;
    }

}
