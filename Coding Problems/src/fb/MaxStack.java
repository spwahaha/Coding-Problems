package fb;

import java.util.Stack;

public class MaxStack {
	Stack<Long> stack;
    long max;
    public MaxStack() {
        stack = new Stack<>();
        max = 0;
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(0L);
            max = x;
        }else{
            stack.push(max - x);
            if(x > max){
                max = x;
            }
        }
    }
    
    public void pop() {
        long val = stack.pop();
        if(val >= 0) return;
        else{
            max = (int)(max + val);
        }
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        long val = stack.peek();
        if(val > 0) return (int)(max - val);
        else return (int)max;
    }
    
    public int getMax() {
        return (int)max;
    }
    
    public static void main(String[] args){
    	MaxStack maxStack = new MaxStack();
    	maxStack.push(2);
    	maxStack.push(0);
    	maxStack.push(3);
    	System.out.println(maxStack.getMax());   
    	maxStack.pop();
    	System.out.println(maxStack.top());   
    	System.out.println(maxStack.getMax());   
    }
}
