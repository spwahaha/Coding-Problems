package leetcode;

public class Longest_Palindromic_Substring {
	//https://leetcode.com/problems/longest-palindromic-substring/
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; i - j >= 0 && i + j < s.length(); j++){
                if(s.charAt(i - j) == s.charAt(i + j)){
                    if(2 * j + 1 > longest.length()) longest = s.substring(i - j, i + j + 1);
                }else break;
            }
            
            for(int j = 0; i - j >= 0 && (i + j + 1) < s.length(); j++){
                if(s.charAt(i - j) == s.charAt(i + j + 1)){
                    if(2 * j + 2 > longest.length()) longest = s.substring(i - j, i + j + 2);
                }else break;
            }
        }
        return longest;
    }
    
    public static void main(String[] args){
    	System.out.println(longestPalindrome("abccbaaa"));
    }
}
