package google;

public class CoinsInALineIII {
	public static boolean firstWillWin(int[] values){
		// if there are even values
		// player one can select all the eventh values
		// or all the oddth values
		int n = values.length;
		int[][] dp = new int[n][n];
		
		search(values, 0, n - 1, dp);
		int sum = 0;
		for(int i = 0; i < values.length; i++){
			sum += values[i];
		}
		int first = dp[0][n - 1];
		int second = sum - first;
		return first > second;
	}
	
	private static int search(int[] values, int i, int j, int[][] dp){
		if(dp[i][j] != 0) return dp[i][j];
		if(i == j){
			dp[i][j] = values[i];
		}else if(i + 1 == j){
			dp[i][j] = Math.max(values[i], values[j]);
		}else{
			int v1 = values[i] + Math.min(search(values, i + 2, j, dp), search(values, i + 1, j - 1, dp));
			int v2 = values[j] + Math.min(search(values, i + 1, j - 1, dp), search(values, i, j - 2, dp));
			dp[i][j] = Math.max(v1, v2);
		}
		return dp[i][j];
	}
	
	public static void main(String[] args){
		System.out.println(firstWillWin(new int[]{3, 2, 2}));
		System.out.println(firstWillWin(new int[]{1, 2, 4}));
		System.out.println(firstWillWin(new int[]{1, 20, 4}));
		System.out.println(firstWillWin(new int[]{1, 2, 3, 4}));
	}
}
