package fb;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	//https://leetcode.com/problems/expression-add-operators/
    public static List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        dfs(num, "", 0, 0, target, list);
        return list;
    }
    
    private static void dfs(String num, String str, long preVal, long curVal, int target, List<String> list){
        if(num.length() == 0){
            if(curVal == target){
                list.add(str);
            }
            return;
        }
        
        for(int i = 1; i <= num.length(); i++){
            String valStr = num.substring(0, i);
            if(i > 1 && valStr.charAt(0) == '0') continue;
            long val = Long.parseLong(valStr);
            if(val > Integer.MAX_VALUE) continue;
            if(str.length() == 0){
                // this is the first part
                dfs(num.substring(i), valStr, val, val, target, list);
            }else{
                dfs(num.substring(i), str + "+" + valStr, val, curVal + val, target, list);
                dfs(num.substring(i), str + "-" + valStr, -val, curVal - val, target, list);
                dfs(num.substring(i), str + "*" + valStr, preVal * val, curVal - preVal + preVal * val, target, list);
            }
        }
    }
    
    public static void main(String[] args){
    	System.out.println(addOperators("1051", 5));
    }
}
