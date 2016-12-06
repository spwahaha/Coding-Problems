package fb;

import java.util.Stack;

public class MinStack {
	//https://leetcode.com/problems/min-stack/
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
    
    public static void main(String[] args){
    	MinStack maxStack = new MinStack();
    	maxStack.push(-2);
    	maxStack.push(0);
    	maxStack.push(-3);
    	System.out.println(maxStack.getMin());   
    	maxStack.pop();
    	maxStack.top();      
    	maxStack.getMin();   
    }
}
