package leetcode;

public class Unique_Paths {
	//https://leetcode.com/problems/unique-paths/
    public static int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        int[][] paths = new int[m][n];
        paths[m - 1][n - 1] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1) continue;
                else if(i == m - 1) paths[i][j] = paths[i][j + 1];
                else if(j == n - 1) paths[i][j] = paths[i + 1][j];
                else paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
            }
        }
        return paths[0][0];
    }
    
    public static int uniquePaths2(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        int[] paths = new int[n];
        paths[n - 1] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1) continue;
                else if(j == n - 1) continue;
                else paths[j] = paths[j] + paths[j + 1];
            }
        }
        return paths[0];
    }
    
    public static void main(String[] args){
    	System.out.println(uniquePaths(3, 7));
    	System.out.println(uniquePaths2(3, 7));
    }
}
