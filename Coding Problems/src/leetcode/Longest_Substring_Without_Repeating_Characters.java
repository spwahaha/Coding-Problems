package leetcode;

import java.util.HashSet;

public class Longest_Substring_Without_Repeating_Characters {
	//https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashSet set = new HashSet<Character>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < s.length()){
            char c = s.charAt(j);
            if(set.contains(c)){
                // repeat character appears
            	System.out.println("set: " + set + "; c: " + c);
                set.remove(s.charAt(i++));
            }else{
                set.add(c);
                max = Math.max(max, set.size());
                j++;
            }
        }
        return max;
    }
    
    public static void main(String[] args){
    	System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    
}
