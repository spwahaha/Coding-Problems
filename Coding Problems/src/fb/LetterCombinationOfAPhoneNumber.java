package fb;
import java.util.*;

public class LetterCombinationOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a','b','c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        
        res.add("");
        for(int i = 0; i < digits.length(); i++){
            List<String> list = new ArrayList<>(res);
            res.clear();
            for(String str : list){
                for(char c : map.get(digits.charAt(i) - '0')){
                    res.add(str + c);
                }
            }
        }
        return res;
    }
    
    
    public static List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a','b','c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        
        helper(digits, res, map, 0, "");
        return res;
    }

    private static void helper(String digits, List<String> res, Map<Integer, List<Character>> map, int pos, String cur){
        if(pos == digits.length()){
            res.add(cur);
            return;
        }
        
        List<Character> list = map.get(digits.charAt(pos) - '0');
        for(char c : list){
            helper(digits, res, map, pos + 1, cur + c);
        }
    }
    
    public static void main(String[] args){
    	System.out.println(letterCombinations("23"));
    	System.out.println(letterCombinations2("23"));
    }
    
}
