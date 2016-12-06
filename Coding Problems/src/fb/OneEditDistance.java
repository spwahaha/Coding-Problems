package fb;

public class OneEditDistance {
    public static boolean isOneEditDistance(String s, String t) {
        for(int i = 0; i < Math.min(s.length(), t.length()); i++){
            if(s.charAt(i) != t.charAt(i)){
                return s.substring(i + ((s.length() >= t.length()) ? 1 : 0)).equals(t.substring(i + ((s.length() <= t.length()) ? 1 : 0)));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
    
    
    public static boolean isOneEditDistance2(String s, String t) {
        for(int i = 0; i < Math.min(s.length(), t.length()); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.length() == t.length()){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }else if(s.length() < t.length()){
                    return s.substring(i).equals(t.substring(i + 1));
                }else{
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
    
    public static void main(String[] args){
    	System.out.println(isOneEditDistance("ba", "a"));
    	System.out.println(isOneEditDistance2("ba", "a"));
    }
}
