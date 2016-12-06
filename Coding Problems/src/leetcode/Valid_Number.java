package leetcode;

public class Valid_Number {
	//https://leetcode.com/problems/valid-number/
    public static boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        s = s.trim();
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                numberSeen = true;
                if(eSeen) numberAfterE = true;
            }else if(c == '.'){
                if(pointSeen || eSeen) return false;
                pointSeen = true;
            }else if(c == '+' || c == '-'){
                if(i != 0 && s.charAt(i - 1) != 'e') return false;
            }else if(c == 'e'){
                if(eSeen || !numberSeen) return false;
                eSeen = true;
            }else{
                return false;
            }
        }
        return (numberSeen && !eSeen) || (numberSeen && eSeen && numberAfterE);
    }
    
    public static void main(String[] args){
    	System.out.println(isNumber("0e"));
    	System.out.println(isNumber("0.1"));
    	System.out.println(isNumber("1 a"));
    }
}
