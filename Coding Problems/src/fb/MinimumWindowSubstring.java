package fb;

import java.util.HashSet;
import java.util.Set;

public class MinimumWindowSubstring {
	//https://leetcode.com/problems/minimum-window-substring/
	/*
	 * count = set(all char in t)
	 * use count to judge whether that contains all the char in that range 
	 */
    public String minWindow(String s, String t) {
        if(s == null || t == null) return "";
        int[] standard = new int[256];
        int[] requires = new int[256];
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            set.add(c);
            standard[c]++;
            requires[c]++;
        }
        int count = set.size();
        int l = 0;
        int r = 0;
        String shortest = "";
        while(r < s.length()){
            while(r < s.length() && count > 0){
                char c = s.charAt(r++);
                if(!set.contains(c)) continue;
                requires[c]--;
                if(requires[c] == 0){
                    count--;
                }
            }
            
            while(l < s.length() && count == 0){
                if((r - l) < shortest.length() || shortest.length() == 0){
                    shortest = s.substring(l, r);
                }
                char c = s.charAt(l++);
                if(!set.contains(c)) continue;
                requires[c]++;
                if(requires[c] == 1){
                    count++;
                }
            }
        }
        return shortest;
    }
    
    /*
     * Two pointers
     * found = t.length();
     * then use found the judge whether that range contains all the char in t
     */
    public String minWindow2(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        int[] Smap = new int[256];
        int[] Tmap = new int[256];
        for(int i = 0; i < t.length(); i++){
            Tmap[t.charAt(i)]++;
        }
        int found = 0;
        int l = 0;
        int r = 0;
        String shortest = "";
        while(r < s.length()){
            while(r < s.length() && found < t.length()){
                int c = s.charAt(r++);
                if(Tmap[c] == 0) continue;
                Smap[c]++;
                if(Smap[c] <= Tmap[c]){
                    found++;
                }
            }
            
            while(l < s.length() && found == t.length()){
                if(shortest == "" || (r - l) < shortest.length()){
                    shortest = s.substring(l, r);
                }
                int c = s.charAt(l++);
                if(Tmap[c] == 0) continue;
                Smap[c]--;
                if(Smap[c] < Tmap[c]){
                    found--;
                }
            }
        }
        return shortest;
    }
}
