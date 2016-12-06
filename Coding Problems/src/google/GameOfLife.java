package google;

import leetcode.Utilis;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = 0;
                for(int I = Math.max(0, i - 1); I < Math.min(i + 2, m); I++){
                    for(int J = Math.max(0, j - 1); J < Math.min(j + 2, n); J++){
                        count += (board[I][J] & 2);
                    }
                }
                if(count == 3 || count - board[i][j] == 3){
                    // there are 2 or 3 neighbors live, 2 cases, current live or dead
                    board[i][j] |= 2;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    public static void main(String[] args){
    	int[][] map = {{1,1},{1,0}};
    	gameOfLife(map);
    	Utilis.printArray(map);
    }
}
