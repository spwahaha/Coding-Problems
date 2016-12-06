package google;

import java.util.Stack;

public class BasicCalculator {
	//https://leetcode.com/problems/basic-calculator/
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int res = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                num = num * 10 + c - '0';
            }else if(c == '+'){
                res += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                res += sign * num;
                num = 0;
                sign = -1;
            }else if(c == '('){
                stack.push(res);
                stack.push(sign);
                num = 0;
                sign = 1;
                res = 0;
            }else if(c == ')'){
                res += sign * num;
                sign = stack.pop();
                res = sign * res + stack.pop();
                num = 0;
                sign = 0;
            }
        }
        
        if(num != 0){
            res += sign * num;
        }
        return res;
    }
    
    public static void main(String[] args){
    	System.out.println(calculate("1 + 2 - (3 + 4)"));
    }
}
