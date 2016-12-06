package google;
import java.util.*;

public class FlipGame {
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) == '+' && s.charAt(i) == '+'){
                res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
            }
        }
        return res;
    }
    
    public static void main(String[] args){
    	System.out.println(generatePossibleNextMoves("++++"));
    }
}
