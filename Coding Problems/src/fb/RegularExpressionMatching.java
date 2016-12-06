package fb;

public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        int m = p.length();
        int n = s.length();
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        for(int i = 1; i < m + 1; i++){
            match[i][0] = i > 1 && match[i - 2][0] && p.charAt(i - 1) == '*'; 
        }
        
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                char pc = p.charAt(i - 1);
                char sc = s.charAt(j - 1);
                if(pc == '*'){
                    match[i][j] = match[i - 2][j] || 
                                    ((p.charAt(i - 2) == sc || p.charAt(i - 2) == '.') && match[i][j - 1]);
                }else if(sc == pc || pc == '.'){
                    match[i][j] = match[i - 1][j - 1];
                }
            }
        }
        
        return match[m][n];
    }
    
    
    public static void main(String[] args){
    	System.out.println(isMatch("aa","a"));
    	System.out.println(isMatch("aa","aa"));
    	System.out.println(isMatch("aaa","aa"));
    	System.out.println(isMatch("aa","a*"));
    	System.out.println(isMatch("aa",".*"));
    	System.out.println(isMatch("ab",".*"));
    	System.out.println(isMatch("aab","c*a*b"));
    }
}
