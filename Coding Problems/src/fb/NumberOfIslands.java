package fb;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	//https://leetcode.com/problems/number-of-islands/
	/*
	 * bfs
	 */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int p = Math.max(m, n);
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j, p);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    private void bfs(char[][] grid, int i, int j, int p){
        Queue<Integer> q = new LinkedList<>();
        q.add(i * p + j);
        grid[i][j] = '2';
        while(!q.isEmpty()){
            int val = q.poll();
            int r = val / p;
            int c = val % p;
            if(r + 1 < grid.length && grid[r + 1][c] == '1'){
                q.add((r + 1) * p + c);
                grid[r + 1][c] = '2';
            }
            if(c + 1 < grid[0].length && grid[r][c + 1] == '1'){
                q.add(r * p + c + 1);
                grid[r][c + 1] = '2';
            }
            if(r - 1 >= 0 && grid[r - 1][c] == '1'){
                q.add((r - 1) * p + c);
                grid[r - 1][c] = '2';
            }
            if(c - 1 >= 0 && grid[r][c - 1] == '1'){
                q.add(r * p + c - 1);
                grid[r][c - 1] = '2';
            }
        }
    }
    
    /*
     * dfs
     */
    public int numIslands2(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) return;
        if(grid[i][j] != '1') return;
        grid[i][j] = '2';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
    
    
}
