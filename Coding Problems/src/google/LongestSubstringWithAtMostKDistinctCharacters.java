package google;

public class LongestSubstringWithAtMostKDistinctCharacters {
    //https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int[] count = new int[256];
        int h = 0;
        int l = 0;
        int num = 0;
        int len = 0;
        for(h = 0; h < s.length(); h++){
            char c = s.charAt(h);
            count[c]++;
            if(count[c] == 1){
                num++;
                while(num > k){
                    char c2 = s.charAt(l++);
                    count[c2]--;
                    if(count[c2] == 0) num--;
                }
            }
            len = Math.max(len, h - l + 1);
        }
        return len;
    }
	
	public static void main(String[] args){
		System.out.println(lengthOfLongestSubstringKDistinct("cornellece", 3));
	}
}
