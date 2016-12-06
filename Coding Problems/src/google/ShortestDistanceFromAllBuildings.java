package google;
import java.util.*;

public class ShortestDistanceFromAllBuildings {
	//https://leetcode.com/problems/shortest-distance-from-all-buildings/
    public static int shortestDistance(int[][] grid) {
        if(grid == null || grid[0].length == 0) return 0;
        int[] shift = new int[]{0, 1, 0, -1, 0};
        int row = grid.length;
        int col = grid[0].length;
        int[][] distance = new int[row][col];
        int[][] reach = new int[row][col];
        int buildingNum = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    buildingNum++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    
                    boolean[][] visited = new boolean[row][col];
                    int level = 1;
                    while(!q.isEmpty()){
                        int size = q.size();
                        for(int p = 0; p < size; p++){
                            int[] cur = q.poll();
                            for(int k = 0; k < 4; k++){
                                int nextRow = cur[0] + shift[k];
                                int nextCol = cur[1] + shift[k + 1];
                                if(nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && grid[nextRow][nextCol] == 0 &&!visited[nextRow][nextCol]){
                                    distance[nextRow][nextCol] += level;
                                    reach[nextRow][nextCol]++;
                                    visited[nextRow][nextCol] = true;
                                    q.add(new int[]{nextRow, nextCol});
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0 && reach[i][j] == buildingNum){
                    min = Math.min(min, distance[i][j]);
                } 
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    public static void main(String[] args){
    	int[][] grid = {{1, 0, 2, 0, 1}, 
    					{0, 0, 0, 0, 0},
    					{0, 0, 1, 0, 0}};
    	System.out.println(shortestDistance(grid));
    }
}
