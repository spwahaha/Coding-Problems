package leetcode;

public class Length_of_Last_Word {
	//https://leetcode.com/problems/length-of-last-word/
    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        if(s.length() == 0) return 0;
        int cnt = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' ') return cnt;
            cnt++;
        }
        return cnt;
    }
    
    public static void main(String[] args){
    	System.out.println(lengthOfLastWord("hello word"));
    	System.out.println(lengthOfLastWord("hello "));
    	System.out.println(lengthOfLastWord(" word"));
    	System.out.println(lengthOfLastWord("helloword"));
    	System.out.println(lengthOfLastWord("  "));
    }
}
