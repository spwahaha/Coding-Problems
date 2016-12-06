package fb;

import java.util.*;

import leetcode.Utilis;

public class SparseMatrixMultiplication {
	//https://leetcode.com/problems/sparse-matrix-multiplication/
    public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int colB = B[0].length;
        
        int[][] C = new int[m][colB];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(A[i][j] != 0){
                    for(int k = 0; k < colB; k++){
                        C[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return C;
    }
	
	public static int[][] multiply2(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int colB = B[0].length;
        int[][] C = new int[m][colB];
        
        List<List<Integer>> Asparse = new ArrayList<>();
        for(int i = 0; i < m; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(A[i][j] != 0){
                    list.add(j);
                }
            }
            Asparse.add(list);
        }
        
        for(int i = 0; i < m; i++){
            List<Integer> list = Asparse.get(i);
            for(int p = 0; p < list.size(); p++){
                int j = list.get(p);
                // A[i][j]
                for(int k = 0; k < colB; k++){
                    C[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return C;
    }
	
	public static void main(String[] args){
		int[][] A = {{1, 0, 0}, {-1, 0, 3}};
		int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
		Utilis.printArray(multiply(A, B));
		Utilis.printArray(multiply2(A, B));
	}
}
