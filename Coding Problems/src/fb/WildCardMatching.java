package fb;

public class WildCardMatching {
	//https://leetcode.com/submissions/detail/53865963/
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int n = s.length();
        int m = p.length();
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        for(int i = 1; i < m + 1; i++){
            match[i][0] = match[i - 1][0] && (p.charAt(i - 1) == '*');
        }
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                char pc = p.charAt(i - 1);
                char sc = s.charAt(j - 1);
                if(pc == '?' || pc == sc){
                    match[i][j] = match[i - 1][j - 1];
                }else if(pc == '*'){
                    match[i][j] = match[i - 1][j] || match[i][j - 1];
                }
            }
        }
        
        return match[m][n];
    }
    
    /*
     * http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
     */
    public boolean isMatch2(String str, String pattern) {
        int s = 0;
        int p = 0;
        int match = 0;
        int starIdx = -1;
        while(s < str.length()){
            if(p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }else if(p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }else if(starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }else{
                return false;
            }
        }
        while(p < pattern.length() && pattern.charAt(p) == '*'){
            p++;
        }
        return p == pattern.length();
    }
}
