package microsoft;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	//https://leetcode.com/problems/implement-queue-using-stacks/
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();
    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(outStack.isEmpty()){
            moveElements();
        }
        outStack.pop();
    }

    // Get the front element.
    public int peek() {
        if(outStack.isEmpty()){
            moveElements();
        }
        return outStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }
    
    private void moveElements(){
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
}
