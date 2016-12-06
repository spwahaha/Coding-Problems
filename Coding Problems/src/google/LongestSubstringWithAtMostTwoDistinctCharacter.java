package google;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacter {
    //https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int h = 0;
        int l = 0;
        int len = 0;
        while(h < s.length()){
            if(map.size() <= 2){
                char c = s.charAt(h);
                map.put(c, h);
                h++;
            }
            if(map.size() > 2){
                int minPos = s.length();
                for(int pos : map.values()){
                    minPos = Math.min(minPos, pos);
                }
                map.remove(s.charAt(minPos));
                l = minPos + 1;
            }
            len = Math.max(len, h - l);
        }
        return len;
    }
}
