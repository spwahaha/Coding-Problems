package fb;

public class UniquePaths {
	//https://leetcode.com/problems/unique-paths/
	
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0) res[i][j] = 1;
                else res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }
	
	
    public int uniquePaths2(int m, int n) {
        int[] f = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0) f[j] = 1;
                else f[j] = f[j] + f[j - 1];
            }
        }
        return f[n - 1];
    }
}
