package leetcode;

public class Rotate_Image {
	//https://leetcode.com/problems/rotate-image/
    public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++){
            for(int j = i; j < n - i - 1; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
    
    public static void main(String[] args){
    	int[][] nums = {{1,2,3,4},
    					{5,6,7,8},
    					{9,10,11,12},
    					{13,14,15,16}};
    	Utilis.printArray(nums);
    	rotate(nums);
    	System.out.println("---------------------------------");
    	Utilis.printArray(nums);
    }
    
    
}
