package google;

public class AndroidUnlockPattens {
	//https://leetcode.com/problems/android-unlock-patterns/
    public static int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[7][9] = skip[9][7] = 8;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5;
        int res = 0;
        boolean[] visited = new boolean[10];
        visited[0] = true;
        for(int i = m; i <= n; i++){
            res += helper(skip, visited, 1, i - 1) * 4;
            res += helper(skip, visited, 2, i - 1) * 4;
            res += helper(skip, visited, 5, i - 1);
        }
        return res;
    }
    
    private static int helper(int[][] skip, boolean[] visited, int start, int remining){
        if(remining == 0) return 1;
        int res = 0;
        visited[start] = true;
        for(int i = 1; i <= 9; i++){
            if(!visited[i] && visited[skip[start][i]]){
                res += helper(skip, visited, i, remining - 1);
            }
        }
        visited[start] = false;
        return res;
    }
    
    public static void main(String[] args){
    	System.out.println(numberOfPatterns(1,1));
    }
    
    
}
