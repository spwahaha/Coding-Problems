package leetcode;

public class Sudoku_Solver {
    public static void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board);
    }
    
    private static boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(valid(board, i, j, c)){
                            board[i][j] = c;
                            if(solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean valid(char[][] board, int r, int c, char ch){
        for(int row = 0; row < board.length; row++){
            if(board[row][c] == ch) return false;
        }
        for(int col = 0; col < board.length; col++){
            if(board[r][col] == ch) return false;
        }
        for(int row = r / 3 * 3; row < r / 3 * 3 + 3; row++){
            for(int col = c / 3 * 3; col < c / 3 * 3 + 3; col++){
                if(board[row][col] == ch) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
    	char[][] board = {{'.','.','9','7','4','8','.','.','.'},
    						{'7','.','.','.','.','.','.','.','.'},
    						{'.','2','.','1','.','9','.','.','.'},
    						{'.','.','7','.','.','.','2','4','.'},
    						{'.','6','4','.','1','.','5','9','.'},
    						{'.','9','8','.','.','.','3','.','.'},
    						{'.','.','.','8','.','3','.','2','.'},
    						{'.','.','.','.','.','.','.','.','6'},
    						{'.','.','.','2','7','5','9','.','.'}};
    	solveSudoku(board);
    	for(char[] bd : board){
    		for(char c : bd){
    			System.out.print(c+" ");
    		}
    		System.out.println();
    	}
    }
    
}
