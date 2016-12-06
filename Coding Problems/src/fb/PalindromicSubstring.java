package fb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromicSubstring {
    public List<String> palindromicSubstring(String s) {
    	Set<String> set = new HashSet<String>();
    	int len = s.length();
    	boolean[][] isPalin = new boolean[len][len];
    	for(int i = 0; i < s.length(); i++){
    		isPalin[i][i] = true;
    		set.add(s.substring(i, i + 1));
    	}
    	for(int l = 2; l <= s.length(); l++){
    		for(int i = 0; i + l - 1 < len; i++){
    			int j = i + l - 1;
    			if(s.charAt(i) == s.charAt(j) && (isPalin[i + 1][j - 1] || i == j - 1)){
    				isPalin[i][j] = true;
    				set.add(s.substring(i, j + 1));
    			}
    		}
    	}
    	return new ArrayList<>(set);
    }
    
    public List<String> palindromicSubstring2(String s) {
    	Set<String> set = new HashSet<String>();
    	for(int i = 0; i < s.length(); i++){
    		// even
    		for(int j = 0; i + j + 1 < s.length() && i - j >= 0; j++){
    			if(s.charAt(i + j + 1) == s.charAt(i - j)){
    				set.add(s.substring(i - j, i + j + 2));
    			}else{
    				break;
    			}
    		}
    		// odd
    		for(int j = 0;i - j >= 0 && i + j < s.length() ; j++){
    			if(s.charAt(i - j) == s.charAt(i + j)){
    				set.add(s.substring(i - j, i + j + 1));
    			}else{
    				break;
    			}
    		}
    	}
    	return new ArrayList<>(set);
    }

    
    
    public static void main(String[] arg) {
        PalindromicSubstring a = new PalindromicSubstring();
        System.out.println(a.palindromicSubstring("abcbdddbckhh"));
        System.out.println(a.palindromicSubstring2("abcbdddbckhh"));
    }
    

}
