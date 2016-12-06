package google;

public class BombEnemy {
	//https://leetcode.com/problems/bomb-enemy/
    public static int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] colHits = new int[n];
        int rowHits = 0;
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 'W') continue;
                if(j == 0 || grid[i][j - 1] == 'W'){
                    rowHits = hitRow(grid, i, j);
                }
                if(i == 0 || grid[i - 1][j] == 'W'){
                    colHits[j] = hitCol(grid, i, j);
                }
                if(grid[i][j] == '0'){
                    max = Math.max(max, rowHits + colHits[j]);
                }
            }
        }
        return max;
    }
    
    
    private static int hitRow(char[][] grid, int i, int j){
        int cnt = 0;
        for(; j < grid[0].length && grid[i][j] != 'W'; j++){
            if(grid[i][j] == 'E')
                cnt++;
        }
        return cnt;
    }
    
    private static int hitCol(char[][] grid, int i, int j){
        int cnt = 0;
        for(; i < grid.length && grid[i][j] != 'W'; i++){
            if(grid[i][j] == 'E')
                cnt++;
        }
        return cnt;
    }
    
    public static void main(String[] args){
    	char[][] grid = {{'0', 'E', '0', '0'},
    					 {'E', '0', 'W', 'E'},
    					 {'0', 'E', '0', '0'}};
    	System.out.println(maxKilledEnemies(grid));
    }
    
}
