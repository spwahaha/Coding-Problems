package leetcode;

public class Set_Matrix_Zeroes {
	//https://leetcode.com/problems/set-matrix-zeroes/
    public static void setZeroes(int[][] nums) {
        if(nums == null || nums.length == 0) return;
        boolean zeroInFirstRow = false;
        boolean zeroInFirstCol = false;
        for(int i = 0; i < nums[0].length; i++){
            if(nums[0][i] == 0){
                zeroInFirstRow = true;
                break;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i][0] == 0){
                zeroInFirstCol = true;
                break;
            }
        }
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 1; j < nums[0].length; j++){
                if(nums[i][j] == 0){
                    nums[i][0] = 0;
                    nums[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i][0] == 0){
                setRowZero(nums, i);
            }
        }
        for(int i = 1; i < nums[0].length; i++){
            if(nums[0][i] == 0){
                setColZero(nums, i);
            }
        }
        
        if(zeroInFirstRow){
            setRowZero(nums, 0);
        }
        
        if(zeroInFirstCol){
            setColZero(nums, 0);
        }
    }
    
    private static void setRowZero(int[][] nums, int r){
        for(int i = 0; i < nums[0].length; i++){
            nums[r][i] = 0;
        }
    }
    
    private static void setColZero(int[][] nums, int c){
        for(int i = 0; i < nums.length; i++){
            nums[i][c] = 0;
        }
    }
    
    public static void main(String[] args){
    	int[][] nums = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
    	Utilis.printArray(nums);
    	System.out.println("----------------------------------");
    	setZeroes(nums);
    	Utilis.printArray(nums);
    }
    
}
