package google;

public class FindTheDifference {
	//https://leetcode.com/problems/find-the-difference/
    public static char findTheDifference(String s, String t) {
        char c = 0;
        for(int i = 0; i < s.length(); i++){
            c ^= s.charAt(i);
        }
        for(int i = 0; i < t.length(); i++){
            c ^= t.charAt(i);
        }
        return c;
    }
    
    
    public static char findTheDifference2(String s, String t) {
        int[] c = new int[26];
        for(int i = 0; i < s.length(); i++){
            c[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            c[t.charAt(i) - 'a']--;
            if(c[t.charAt(i) - 'a'] == -1) return t.charAt(i);
        }
        return '0';
    }
    
    public static void main(String[] args){
    	System.out.println(findTheDifference("abcd", "eadcb"));
    	System.out.println(findTheDifference2("abcd", "eadcb"));
    }
}
