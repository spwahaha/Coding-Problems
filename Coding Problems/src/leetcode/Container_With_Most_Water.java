package leetcode;

public class Container_With_Most_Water {
	//https://leetcode.com/problems/container-with-most-water/
    public static int maxArea(int[] height) {
        if(height == null || height.length < 2) return 0;
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while(i < j){
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]) i++;
            else j--;
        }
        return maxArea;
    }
    
    public static void main(String[] args){
    	int[] nums1 = {1,3,3,3};
    	int[] nums2 = {1,3,1};
    	int[] nums3 = {};
    	System.out.println( maxArea(nums1) );
    	System.out.println( maxArea(nums2) );
    	System.out.println( maxArea(nums3) );    	
    }
}
