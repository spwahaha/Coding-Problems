package microsoft;

public class TicTacToe {
	
	//https://leetcode.com/problems/design-tic-tac-toe/
    int[] rows;
    int[] cols;
    int diag = 0;
    int antiDiag = 0;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        rows[row] += add;
        cols[col] += add;
        int n = cols.length;
        if(row == col){
            diag += add;
        }
        if(row == n - 1 - col){
            antiDiag += add;
        }
        if(Math.abs(diag) == n || Math.abs(antiDiag) == n ||
            Math.abs(cols[col]) == n || Math.abs(rows[row]) == n){
                return add == 1 ? 1 : 2;
            }
        return 0;
    }
}
