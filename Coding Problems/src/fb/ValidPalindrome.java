package fb;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] ls = s.toCharArray();
        int l = 0;
        int r = ls.length - 1;
        while(l < r){
            while(r > l && !Character.isLetterOrDigit(ls[r])){
                r--;
            }
            while(l < r && !Character.isLetterOrDigit(ls[l])){
                l++;
            }
            if(Character.toLowerCase(ls[l++]) != Character.toLowerCase(ls[r--])) return false;
        }
        return true;
    }
}
