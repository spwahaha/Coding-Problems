package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {
	//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    public static List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return res;
        combine(letters, digits, 0, "", res);
        return res;
    }
    
    private static void combine(String[] letters, String digits, int level, String cur, List<String> res){
        if(level == digits.length()){
            res.add(cur);
            return;
        }
        int digit = digits.charAt(level) - '0';
        for(int i = 0; i < letters[digit].length(); i++){
            char c = letters[digit].charAt(i);
            combine(letters, digits, level + 1, cur + c, res);
        }
    }
    
    public static List<String> letterCombinations2(String digits) {
        String[] letters = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return list;
        list.add("");
        for(int i = 0; i < digits.length(); i++){
            int digit = digits.charAt(i) - '0';
            String str = letters[digit];
            int size = list.size();
            List<String> temp = new ArrayList<String>();
            for(int j = 0; j < size; j++){
                for(int k = 0; k < str.length(); k++){
                    temp.add(list.get(j) + str.charAt(k));
                }
            }
            list = temp;
        }
        return list;
    }
    
    public static void main(String[] args){
    	System.out.println(letterCombinations("23"));
    	System.out.println(letterCombinations2("23"));
    }
}
