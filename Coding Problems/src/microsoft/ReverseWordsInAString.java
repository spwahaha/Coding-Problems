package microsoft;

public class ReverseWordsInAString {
	
    public String reverseWords(String str) {
        if(str == null || str.length() == 0) return "";
        str = str.trim();
        return reverse(str.toCharArray());
    }
    
    private String reverse(char[] s){
        int i = 0;
        int j = 0;
        while(i < s.length){
            while(i < s.length && s[i] == ' '){
                i++;
            }
            j = i + 1;
            while(j < s.length && s[j] != ' '){
                j++;
            }
            j--;
            reverse(s, i, j);
            i = j + 1;
        }
        reverse(s, 0, s.length - 1);
        int pos = 0;
        for(i = 0; i < s.length; i++){
            if(s[i] == ' ' && s[i - 1] == ' ') continue;
            s[pos++] = s[i];
        }
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < pos; i++){
            sb.append(s[i]);
        }
        return sb.toString();
    }
    
    private void reverse(char[] s, int i, int j){
        while(i < j){
            swap(s, i++, j--);
        }
    }
    
    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    
    public static void main(String[] args){
    	ReverseWordsInAString s = new ReverseWordsInAString();
    	System.out.println(s.reverseWords("   a   b "));
    }
}
