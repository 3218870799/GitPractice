package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow417 {

}
class Solution {
	//��ʾ��άƽ�������������
    private int m, n;
    //��ʾ�ĸ����������
    private int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //�ж�ĳ������x,y�Ƿ��ھ���������
    private boolean in_area(int x, int y){
        return 0 <= x && x < m && 0 <= y && y < n;
    }
    //�ӵ�ǰ�ڵ����������x��y,�߶�Ϊh���ܲ��ܵ���P�������ܲ��ܵ���A
    //
/*    private void dfs(int[][] matrix, int x, int y, int[][] tmp){
        tmp[x][y] = 1;
        for (int[] d : direction) {
            int newx = x + d[0];
            int newy = y + d[1];
            if (!in_area(newx, newy) || matrix[x][y] > matrix[newx][newy] || tmp[newx][newy] == 1){
                continue;
            }
            dfs(matrix, newx, newy, tmp);
        }
    }
    */
    /**
     * ��һ��˼·���ӱ߽��������ߣ�ֻ���ߵ����Լ����߻��ߵȸߵĵط����߽����ߵ��ĵط��������������Ӧ����ĵط���
     */
    private void dfs(int[][] matrix,int x, int y, boolean[][] canReach) {
    	//����ǰ������Ϊ�ѷ���
        canReach[x][y] = true;
        //�����������Ǹ�������б�����
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            //������㣺�ھ����ڣ��߶ȱȵ�ǰ����߻�����ȣ��һ�û�б����ʹ����Ͷ������
            if (in_area(newX, newY) && matrix[x][y] <= matrix[newX][newY] && !canReach[newX][newY]) {
                dfs(matrix,newX, newY, canReach);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    	//������꼯�ϣ����ܵ�̫ƽ�����ܵ�����������꼯��
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (matrix == null || matrix.length == 0)
            return ans;
        //����
        m = matrix.length;
        //����
        n = matrix[0].length;
        //�ܵ�̫ƽ��Ľ������ ���ܵ�������Ľ�����ϣ��ܵ��������Ϊ1�����ܵ�Ϊ0
        //int[][] po = new int[m][n], ao = new int[m][n]; //po ̫ƽ��ao ������
        boolean[][] po = new boolean[m][n];
        boolean[][] ao = new boolean[m][n];
        //
        for (int i = 0; i < n; ++i){
            dfs(matrix, 0, i, po);
            dfs(matrix, m - 1, i, ao);
        }
        //
        for (int i = 0; i < m; ++i){
            dfs(matrix, i, 0, po);
            dfs(matrix, i, n - 1, ao);
        }
        //�Զ�άƽ�������е���б������ҵ������Ե���ĵ�
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (po[i][j] && ao[i][j] ){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}
