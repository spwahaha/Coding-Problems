package fb;

import java.util.ArrayList;
import java.util.List;

public class FindLongestConsecutiveCharacter {
    public static List<Character> find(String s) {
    	int maxLen = 0;
    	List<Character> res = new ArrayList<>();
    	for(int i = 0; i < s.length();){
    		char c = s.charAt(i);
    		int cnt = 0;
    		int j = i;
    		for(; j < s.length() && s.charAt(j) == c; j++){
    			cnt++;
    		}
    		if(cnt > maxLen){
    			maxLen = cnt;
    			res = new ArrayList<>();
    		}
    		if(cnt == maxLen){
    			res.add(c);
    		}
    		i = j;
    	}
    	return res;
    }
    
    public static void main(String[] arg) {
        System.out.println(find("taahaslkqp"));
        System.out.println(find("heyworld"));
        System.out.println(find("hello, worldd"));
    }
}
