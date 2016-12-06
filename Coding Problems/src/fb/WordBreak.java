package fb;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordBreak {
	//https://leetcode.com/problems/word-break/
    public static boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || wordDict == null) return false;
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = i; j >= 0; j--){
                if(f[j] && wordDict.contains(s.substring(j,i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
    
    public static boolean wordBreak2(String s, Set<String> wordDict) {
        if(s == null || wordDict == null) return false;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(0);
        while(!q.isEmpty()){
            int index = q.poll();
            if(visited.contains(index)) continue;
            visited.add(index);
            for(int i = 1; i + index <= s.length(); i++){
                if(wordDict.contains(s.substring(index, index + i))){
                    if(index + i == s.length()) return true;
                    q.add(index + i);
                }
            }
        }
        return false;
    }
    
    public static void main(String[] arg) {
        WordBreak a = new WordBreak();
        System.out.println(wordBreak("leetcode", new HashSet<>(Arrays.asList("leet", "code"))));
        System.out.println(wordBreak("leetcode", new HashSet<>(Arrays.asList("leet", "cod"))));
        System.out.println(wordBreak2("leetcode", new HashSet<>(Arrays.asList("leet", "code"))));
        System.out.println(wordBreak2("leetcode", new HashSet<>(Arrays.asList("leet", "cod"))));
    }
}
