package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        if(s == null || wordDict == null || s.length() == 0 || wordDict.size() == 0) return new ArrayList<String>();
        List<String> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : wordDict){
            map.put(str, new ArrayList<>(Arrays.asList(str)));
        }
        map.put("", new ArrayList<>(Arrays.asList("")));
        for(int i = 1; i <= s.length(); i++){
            List<String> list = new ArrayList<>();
            for(int j = i - 1; j >= 0; j--){
                if(wordDict.contains(s.substring(j, i)) && map.containsKey(s.substring(0,j))){
                    List<String> strs = map.get(s.substring(0, j));
                    for(String str : strs){
                    	if(str.equals("")) list.add(s.substring(j,i));
                    	else list.add(str + " " + s.substring(j, i));
                    }
                }
            }
            map.put(s.substring(0, i), list);
        }
        return map.get(s);
    }
    
    public static List<String> wordBreak2(String s, Set<String> wordDict) {
        return wordBreak2(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private static List<String> wordBreak2(String s, Set<String> wordDict, HashMap<String, List<String>> map){
        if(s.length() == 0){
            return new ArrayList<String>(Arrays.asList(""));
        }
        if(map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<String>();
        for(int i = 1; i <= s.length(); i++){
            if(wordDict.contains(s.substring(0, i))){
                List<String> list = wordBreak2(s.substring(i), wordDict, map);
                for(String str : list){
                    res.add(s.substring(0,i) + (str.isEmpty() ? "" : " ") + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }
    
    
    
    public static void main(String[] arg) {
        WordBreak a = new WordBreak();
        System.out.println(wordBreak("leetcode", new HashSet<>(Arrays.asList("leet", "code"))));
        System.out.println(wordBreak("leetcode", new HashSet<>(Arrays.asList("leet", "cod"))));
        System.out.println(wordBreak2("leetcode", new HashSet<>(Arrays.asList("leet", "code"))));
        System.out.println(wordBreak2("leetcode", new HashSet<>(Arrays.asList("leet", "cod"))));
    }
}
