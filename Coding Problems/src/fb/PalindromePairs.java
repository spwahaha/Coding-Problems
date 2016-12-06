package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
	//https://leetcode.com/problems/palindrome-pairs/
	public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length(); j++){
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if(isPalindrome(s1)){
                    String s2rev = new StringBuilder(s2).reverse().toString();
                    if(map.containsKey(s2rev) && map.get(s2rev) != i){
                        List<Integer> list = new ArrayList<>(Arrays.asList(map.get(s2rev), i));
                        res.add(list);
                    }
                }
                
                if(isPalindrome(s2)){
                    String s1rev = new StringBuilder(s1).reverse().toString();
                    /*
                     *  s2.length() > 0 to avoid duplicates
                     *  {"bb", "bb"}  
                     */
                    if(map.containsKey(s1rev) && map.get(s1rev) != i && s2.length() > 0){
                        List<Integer> list = new ArrayList<>(Arrays.asList(i, map.get(s1rev)));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    
    private static boolean isPalindrome(String s){
        if(s == null || s.length() < 2) return true;
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
    
    public static void main(String[] args){
        System.out.println(palindromePairs(new String[]{"cigar", "tragic", "none", "xenon"}));
        System.out.println(palindromePairs(new String[]{"bb", "bb"}));
    }
}
