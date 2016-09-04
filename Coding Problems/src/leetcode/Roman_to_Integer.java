package leetcode;

import java.util.HashMap;

public class Roman_to_Integer {
	//https://leetcode.com/problems/roman-to-integer/
    public static int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int res = map.get(s.charAt(s.length() - 1));
        for(int i = s.length() - 2; i >= 0; i--){
            int cur = map.get(s.charAt(i));
            int last = map.get(s.charAt(i + 1));
            if(cur < last) res -= cur;
            else res += cur;
        }
        return res;
    }
    
    public static void main(String[] args){
    	System.out.println(romanToInt("MMMCMXCIX"));
    	System.out.println(romanToInt("I"));
    	System.out.println(romanToInt("CCCXCIX"));
    	System.out.println(romanToInt("C"));
    }
}
