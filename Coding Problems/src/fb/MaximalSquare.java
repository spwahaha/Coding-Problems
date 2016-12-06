package fb;

public class MaximalSquare {
	public static int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] squares = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    squares[i][j] = matrix[i][j] - '0';
                }else if(i == 0 || j == 0){
                    squares[i][j] = matrix[i][j] - '0';
                }else{
                    if(matrix[i][j] == '0'){
                        squares[i][j] = 0;
                    }else{
                        squares[i][j] = Math.min(Math.min(squares[i - 1][j], squares[i - 1][j - 1]), squares[i][j - 1]) + 1;
                    }
                }
                max = Math.max(max, squares[i][j]);
            }
        }
        return max * max;
    }
	
	public static void main(String[] args){
		//["1010","1011","1011","1111"]
		char[][] matrix = {{'1','0','1','0'},
						   {'1','0','1','1'},
						   {'1','0','1','1'},
						   {'1','1','1','1'}};
		System.out.println(maximalSquare(matrix));
	}
}
