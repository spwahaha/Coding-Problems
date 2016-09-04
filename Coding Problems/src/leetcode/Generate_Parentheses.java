package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if(n < 0) return list;
        generate(n, n, list, "");
        return list;
    }
    
    private static void generate(int lleft, int rleft, List<String> list, String cur){
        if(lleft < 0 || rleft < 0) return;
        if(lleft > rleft) return;
        if(lleft == 0 && rleft == 0) {
            list.add(cur);
            return;
        }
        generate(lleft - 1, rleft, list, cur + "(");
        generate(lleft, rleft - 1, list, cur + ")");
    }
    
    public static void main(String[] args){
    	System.out.println(generateParenthesis(3));
    }
}
