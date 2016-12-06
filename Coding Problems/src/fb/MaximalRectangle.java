package fb;

import java.util.Stack;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] hei = new int[n];
        int max=  0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '0') hei[j] = 0;
                else hei[j] += 1;
            }
            max = Math.max(max, maxRec(hei));
        }
        return max;
    }
    
    private static int maxRec(int[] hei){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= hei.length; i++){
            int cur = i == hei.length ? -1 : hei[i];
            while(!stack.isEmpty() && cur < hei[stack.peek()]){
                int h = hei[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
    
    public static void main(String[] args){
    	char[][] matrix = {{'1','0','1','0','0'},
    					   {'1','0','1','1','1'},
    					   {'1','1','1','1','1'},
    					   {'1','0','0','1','0'}};
    	System.out.println(maximalRectangle(matrix));
    }
}
