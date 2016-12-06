package google;

public class FlipGameII {
    public static boolean canWin(String s) {
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '+' && s.charAt(i - 1) == '+'){
                if(!canWin(s.substring(0, i - 1) + "--" +s.substring(i + 1)))
                    return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
    	System.out.println(canWin("++++"));
    }
}
