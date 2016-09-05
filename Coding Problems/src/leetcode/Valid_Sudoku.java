package leetcode;

public class Valid_Sudoku {

	//https://leetcode.com/problems/valid-sudoku/
    public static boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blks = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int digit = board[i][j] - '1';
                if(rows[i][digit]) return false;
                if(cols[j][digit]) return false;
                int blk = i / 3 * 3 + j / 3;
                if(blks[blk][digit]) return false;
                rows[i][digit] = true;
                cols[j][digit] = true;
                blks[blk][digit] = true;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
    	char[][] board = {{'.','8','7','6','5','4','3','2','1'},
    						{'2','8','.','.','.','.','.','.','.'},
    						{'3','.','.','.','.','.','.','.','.'},
    						{'4','.','.','.','.','.','.','.','.'},
    						{'5','.','.','.','.','.','.','.','.'},
    						{'6','.','.','.','.','.','.','.','.'},
    						{'7','.','.','.','.','.','.','.','.'},
    						{'8','.','.','.','.','.','.','.','.'},
    						{'9','.','.','.','.','.','.','.','.'}};
    	System.out.println(isValidSudoku(board));
    	board[1][1] = '.';
    	System.out.println(isValidSudoku(board));
    }
}
