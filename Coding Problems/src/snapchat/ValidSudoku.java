package snapchat;

import java.util.Scanner;

public class ValidSudoku {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char[][] board = convert(sc.nextLine());
		System.out.println(inValid(board));
	}
	
	private static char[][] convert(String strs){
		char[][] board = new char[9][9];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				board[i][j] = strs.charAt(i * 9 + j);
			}
		}
		return board;
	}
	
	private static boolean inValid(char[][] board){
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blks = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int num = board[i][j] - '1';
                if(rows[i][num]){
                    return false;
                }
                rows[i][num] = true;
                if(cols[j][num]){
                    return false;
                }
                cols[j][num] = true;
                int blk = i / 3 * 3 + j / 3;
                if(blks[blk][num]){
                    return false;
                }
                blks[blk][num] = true;
            }
        }
        return true;
	}
}
