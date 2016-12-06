package google;

public class MinimumInsertionsToFormAPalindrome {
	public static int minimumInsertions(String str){
		if(str == null || str.length() == 0) return 0;
		int len = str.length();
		int[][] dp = new int[len][len];
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				dp[i][j] = -1;
			}
		}
		return helper(dp, str, 0, len - 1);
	}
	
	private static int helper(int[][] dp, String word, int start, int end){
		if(start > end) return 0;
		if(dp[start][end] != -1) return dp[start][end];
		if(start == end){
			dp[start][end] = 0;
			return 0;
		}
		char c1 = word.charAt(start);
		char c2 = word.charAt(end);
		int res = 0;
		if(c1 == c2){
			res = helper(dp, word, start + 1, end - 1);
		}else{
			res = 1 + Math.min(helper(dp, word, start + 1, end), helper(dp, word, start, end - 1));
		}
		dp[start][end] = res;
		return res;
	}
	
	public static void main(String[] args){
		System.out.println(minimumInsertions("ab"));
		System.out.println(minimumInsertions("aa"));
		System.out.println(minimumInsertions("abcd"));
		System.out.println(minimumInsertions("abcda"));
		System.out.println(minimumInsertions("abcde"));
	}
}
