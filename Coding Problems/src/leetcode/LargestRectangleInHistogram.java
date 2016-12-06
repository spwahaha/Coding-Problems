package leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {
	//https://leetcode.com/problems/largest-rectangle-in-histogram/
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i <= heights.length; i++){
            int cur = 0;
            if(i == heights.length){
                cur = -1;
            }else{
                cur = heights[i];
            }
            while(!stack.isEmpty() && cur < heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
