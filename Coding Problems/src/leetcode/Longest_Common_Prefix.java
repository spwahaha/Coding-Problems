package leetcode;

public class Longest_Common_Prefix {
	//https://leetcode.com/problems/longest-common-prefix/
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0 || strs[0].length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 0; j < strs.length; j++){
                if(strs[j] == null || i >= strs[j].length()) return sb.toString();
                if(strs[j].charAt(i) != c) return sb.toString();
            }
            sb.append(""+c);
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
    	String[] strs1 = {"abcde", "abc", "abcd", "ab"};
    	System.out.println(longestCommonPrefix(strs1));
    }
}
