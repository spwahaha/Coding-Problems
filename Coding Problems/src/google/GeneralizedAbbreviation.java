package google;
import java.util.*;

public class GeneralizedAbbreviation {
	//https://leetcode.com/problems/generalized-abbreviation/
    public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if(word == null) return res;
        helper(res, word, "", 0, 0);
        return res;
    }
    
    private static void helper(List<String> res, String word, String cur, int pos, int cnt){
        if(pos == word.length()){
            if(cnt > 0) cur += cnt;
            res.add(cur);
            return;
        }
        // abbe pos
        helper(res, word, cur, pos + 1, cnt +1);
        helper(res, word, cur + (cnt > 0 ? cnt : "") + word.charAt(pos), pos + 1, 0);
    }
    
    public static void main(String[] args){
    	System.out.println(generateAbbreviations("word"));
    }
}
