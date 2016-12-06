package fb;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	//https://leetcode.com/problems/palindrome-partitioning/
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, res, new ArrayList<String>());
        return res;
    }
    
    private void helper(String s, List<List<String>> res, List<String> list){
        if(s.length() == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 1; i <= s.length(); i++){
            String str = s.substring(0, i);
            if(isPalin(str)){
                list.add(str);
                helper(s.substring(i), res, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalin(String s){
        if(s.length() < 2) return true;
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
    

    public static void main(String[] args) {
        PalindromePartitioning a = new PalindromePartitioning();
        System.out.println(a.partition("sissskdjalaj"));
    }
}
