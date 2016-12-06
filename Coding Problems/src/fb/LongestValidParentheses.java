package fb;

import java.util.Stack;

public class LongestValidParentheses {
	//https://leetcode.com/problems/longest-valid-parentheses/
	/*
	 * when there is a valid parentheses, 
	 * calculate the different between current position and 
	 * the last invalid position
	 * invalid position consists of 2 cases:
	 * 1. last invalid position is a ')', use left represent its index
	 * 2. last invalid position is a '(', use stack.peek() to record 
	 * @param s
	 * @return
	 */
    public static int longestValidParentheses(String s) {
        if(s == null || s.length() < 2) return 0;
        int left = -1;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                	// this is a invalid '('
                    left = i;
                }else{
                	// remove a '(' that is consumed by ')'
                    stack.pop();
                    if(stack.isEmpty()){
                    	// no extra '(', difference between cur and last invalid ')'
                        max = Math.max(max, i - left);
                    }else{
                    	// extra '(', difference between cur and extra '('
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
