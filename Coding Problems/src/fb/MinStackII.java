package fb;

import java.util.Stack;

public class MinStackII {
	//https://leetcode.com/problems/min-stack/
    /** initialize your data structure here. */
    Stack<Long> stack;
    long min;
    public MinStackII() {
        stack = new Stack<>();
        min = 0;
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(0L);
            min = x;
        }else{
            stack.push(x - min);
            if(x < min){
                min = x;
            }
        }
    }
    
    public void pop() {
        long val = stack.pop();
        if(val >= 0) return;
        else{
            min = (int)(min - val);
        }
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        long val = stack.peek();
        if(val > 0) return (int)(val + min);
        else return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}
