package fb;

public class KWindow {
	/*
	 * find k non-overlapping window, 
	 * window size is n,
	 * make the sum of all window maximum
	 */
	public static int getMaxValue(int[] nums, int n, int k){
		int len = nums.length;
		for(int i = 1; i < len; i++){
			nums[i] += nums[i - 1];
		}
		
		if(len < n * k) return -1;
		int[][] dp = new int[k + 1][len + 1];
		for(int i = 1; i <= k; i++){
			for(int j = 1; j <= len; j++){
				if(j <= n) dp[i][j] = nums[j - 1];
				else dp[i][j] = Math.max(dp[i][j - 1],
						nums[j - 1] - nums[j - n - 1] + dp[i - 1][j - n - 1]);
			}
		}
		return dp[k][len];
	}
	
	public static void main(String[] args){
		System.out.println(getMaxValue(new int[]{1,3,7,7,2,1,1,4,8,8,6,1,1,9}, 2, 3));
	}
}
