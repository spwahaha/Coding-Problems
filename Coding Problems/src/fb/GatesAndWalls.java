package fb;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.Utilis;

public class GatesAndWalls {
    public static void wallsAndGates(int[][] rooms) {
    	if(rooms == null || rooms.length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;
        int INF = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
             for(int i = 0; i < size; i++){
                 int[] p = q.poll();
                 int x = p[0];
                 int y = p[1];
                 if(x - 1 >= 0 && rooms[x - 1][y] == INF){
                     rooms[x - 1][y] = rooms[x][y] + 1;
                     q.add(new int[]{x - 1, y});
                 }
                 if(x + 1 < m && rooms[x + 1][y] == INF){
                     rooms[x + 1][y] = rooms[x][y] + 1;
                     q.add(new int[]{x + 1, y});
                 }
                 if(y - 1 >= 0 && rooms[x][y - 1] == INF){
                     rooms[x][y - 1] = rooms[x][y] + 1;
                     q.add(new int[]{x, y - 1});
                 }
                 if(y + 1 < n && rooms[x][y + 1] == INF){
                     rooms[x][y + 1] = rooms[x][y] + 1;
                     q.add(new int[]{x, y + 1});
                 }
             }
        }
    }
    
    public static void main(String[] args){
    	int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
    	wallsAndGates(rooms);
    	Utilis.printArray(rooms);
    }
    
}
