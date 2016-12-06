package google;

public class SearchA2DMatrix {
	//https://leetcode.com/problems/search-a-2d-matrix-ii/
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int r = matrix.length - 1;
        int c = 0;
        while(r >= 0 && c < matrix[0].length){
            int val = matrix[r][c];
            if(val == target) return true;
            if(val < target){
                c++;
            }else{
                r--;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
    	int[][] matrix = {{1,   4,  7, 11, 15},
    					  {2,   5,  8, 12, 19},
    					  {3,   6,  9, 16, 22},
    					  {10, 13, 14, 17, 24},
    					  {18, 21, 23, 26, 30}};
    	System.out.println(searchMatrix(matrix, 5));
    	System.out.println(searchMatrix(matrix, 20));
    }
}
