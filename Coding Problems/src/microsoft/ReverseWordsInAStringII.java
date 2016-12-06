package microsoft;

import leetcode.Utilis;

public class ReverseWordsInAStringII {
	//https://leetcode.com/problems/reverse-words-in-a-string-ii/
    public static void reverseWords(char[] s) {
        int l = -1;
        int r = nextWhitespace(s, 0);
        while(r != -1){
            reverse(s, l + 1, r - 1);
            l = nextWhitespace(s, l);
            r = nextWhitespace(s, r);
        }
        reverse(s, 0, s.length - 1);
    }
    
    private static int nextWhitespace(char[] s, int start){
    	if(start == s.length) return -1;
        for(int i = start + 1; i < s.length; i++){
            if(s[i] == ' ') return i;
        }
        return s.length;
    }
    
    private static void reverse(char[] s, int start, int end){
        while(start < end){
            swap(s, start++, end--);
        }
    }
    
    private static void swap(char[] s, int l, int r){
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
    
    public static void main(String[] args){
    	String str = "the sky is blue";
    	char[] c = str.toCharArray();
    	reverseWords(c);
    	System.out.println(new String(c));
    }
    
    
}
