package fb;

public class LongestCommonString {
	//http://www.lintcode.com/en/problem/longest-common-substring/
    public static int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || B == null) return 0;
        int[][] LCS = new int[A.length() + 1][B.length() + 1];
        int max = 0;
        for(int i = 1; i < A.length() + 1; i++){
            for(int j = 1; j < B.length() + 1; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    max = Math.max(max, LCS[i][j]);
                }else{
                    LCS[i][j] = 0;
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        String A = "tutorialhorizon";
        String B = "dynamictutorialProgramming";
        System.out.println("LCS length : " + longestCommonSubstring(A, B));
    }
}
