package google;

public class ReverseVowelsOfAString {
    public String reverseVowels(String str) {
        char[] s = str.toCharArray();
        int l = 0;
        int r = s.length - 1;
        while(l < r){
            while(l < r && !isVowel(s[l])){
                l++;
            }
            while(l < r && !isVowel(s[r])){
                r--;
            }
            swap(s, l, r);
            l++;
            r--;
        }
        return new String(s);
    }
    
    private boolean isVowel(char c){
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i'
                || c == 'o' || c == 'u';
    }
    
    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
