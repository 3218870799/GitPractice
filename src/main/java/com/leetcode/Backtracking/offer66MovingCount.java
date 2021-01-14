package com.leetcode.Backtracking;

public class offer66MovingCount {

    public int movingCount(int m,int n,int k){
        boolean[][] visited = new boolean[m][n];
        //�����˴�[0,0]��ʼ�ƶ�
        return dfs(m,n,k,visited,0,0);
    }

    private int dfs(int m, int n, int k, boolean[][] visited, int x, int y) {
        //�ݹ���ֹ����,����Ѿ����ʹ����߳���k������
        if((get(x) + get(y) > k) || x <0 ||x>=m || y >=n ||visited[x][y]){
            return 0;
        }
        //���ø��ӱ��Ϊ�Ѿ����ʹ�
        visited[x][y] = true;
        //�ݹ����������ĸ�����
        return 1 + dfs(m,n,k,visited,x,y+1)
                 + dfs(m,n,k,visited,x,y-1)
                 + dfs(m,n,k,visited,x-1,y)
                 + dfs(m,n,k,visited,x+1,y);
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
    /*    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // ���Һ����µķ�������
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }*/
}
