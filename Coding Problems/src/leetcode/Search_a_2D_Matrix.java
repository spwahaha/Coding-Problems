package leetcode;

public class Search_a_2D_Matrix {
	//https://leetcode.com/problems/search-a-2d-matrix/
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
    
    public static void main(String[] args){
    	int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 40, 50}};
    	int target = 30;
    	System.out.println(searchMatrix(matrix, target));
    }
}
