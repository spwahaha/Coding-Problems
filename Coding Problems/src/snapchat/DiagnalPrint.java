package snapchat;

public class DiagnalPrint {
	public static void printDiagnal(int[][] matrix){
		int n = matrix.length;
		int col = 0;
		boolean terminate = false;
		while(!terminate){
			int i = 0; int j = col;
			terminate = true;
			while(i < n && j >= 0){
				if(j < matrix[i].length){
					terminate = false;
					System.out.print("  " + matrix[i][j]);
				}
				i++;
				j--;
			} 
			System.out.println();
			col++;
		}
	}
	
	public static void main(String[] args){
		int[][] matrix = {{1,2,3,4,5}, {4,5,6, 7, 8, 9}, {7,8,9,10}};
		printDiagnal(matrix);
		matrix = new int[][]{{1}, {2,3}, {4,5,6}};
		printDiagnal(matrix);

	}
}
