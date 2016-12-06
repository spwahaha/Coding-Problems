package fb;

public class LongestPalindromicSubstring {
	//https://leetcode.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        if(s == null) return "";
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; i + j < s.length() && i - j >= 0; j++){
                if(s.charAt(i + j) == s.charAt(i - j)){
                    longest = (2 * j + 1) > longest.length() ? s.substring(i - j, i + j + 1) : longest;
                }else{
                    break;
                }
            }
            
            for(int j = 0; i + j + 1 < s.length() && i - j >= 0; j++){
                if(s.charAt(i + j + 1) == s.charAt(i - j)){
                    longest = (2 * j + 2) > longest.length() ? s.substring(i - j, i + j + 2) : longest;
                }else{
                    break;
                }
            }
        }
        return longest;
    }
    
    public String longestPalindrome2(String s) {
        if(s == null) return "";
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            isPalindrome[i][i] = true;
        }
        int begin = 0;
        int max = 1;
        for(int l = 2; l <= s.length(); l++){
            for(int i = 0; i < s.length(); i++){
                int j = i + l - 1;
                if(j < s.length() && s.charAt(i) == s.charAt(j) && (isPalindrome[i + 1][j - 1] || i == j - 1)){
                    isPalindrome[i][j] = true;
                    max = l;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
    
}
