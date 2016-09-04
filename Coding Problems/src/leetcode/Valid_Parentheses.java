package leetcode;

import java.util.Stack;

public class Valid_Parentheses {
	//https://leetcode.com/problems/valid-parentheses/
    public static boolean isValid(String s) {
        if(s == null || s.length() == 0) return false;
        if(s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') stack.push(c);
            else if(c == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else if(c == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
            else if(c == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
            else return false;
        }
        return stack.size() == 0;
    }
    
    public static void main(String[] args){
    	System.out.println(isValid(""));
    	System.out.println(isValid("("));
    	System.out.println(isValid("()"));
    	System.out.println(isValid("())"));
    	System.out.println(isValid("(((()"));
    }
}
