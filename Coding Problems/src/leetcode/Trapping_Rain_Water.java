package leetcode;

public class Trapping_Rain_Water {
	//https://leetcode.com/problems/trapping-rain-water/
    public static int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int highest = -1;
        int highIndex = -1;
        int area = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] > highest){
                highest = height[i];
                highIndex = i;
            }
        }
        int leftMax = height[0];
        for(int i = 0; i < highIndex; i++){
            leftMax = Math.max(leftMax, height[i]);
            area += leftMax - height[i];
        }
        int rightMax = height[n - 1];
        for(int i = n - 1; i > highIndex; i--){
            rightMax = Math.max(rightMax, height[i]);
            area += rightMax - height[i];
        }
        return area;
    }
    
    public static void main(String[] args){
    	int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println(trap(nums));
    }
}
