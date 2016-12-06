package fb;

public class UniquePathsII {
	//https://leetcode.com/problems/unique-paths-ii/
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1) matrix[i][j] = 0;
                else if(i == 0 && j == 0) matrix[i][j] = 1;
                else if(i == 0) matrix[i][j] = matrix[i][j - 1];
                else if(j == 0) matrix[i][j] = matrix[i - 1][j];
                else matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }
}
