package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Group_Anagrams {
	//https://leetcode.com/problems/anagrams/
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String ana = new String(chars);
            List<String> list = map.get(ana);
            if(list == null) list = new ArrayList<String>();
            list.add(str);
            map.put(ana, list);
        }
        
        Set<String> keys = map.keySet();
        for(String key : keys){
            res.add(map.get(key));
        }
        return res;
    }
    
    public static void main(String[] args){
    	String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    	System.out.println(groupAnagrams(strs));
    }
}
