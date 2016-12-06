package snapchat;

import java.util.*;

public class RevertMatrix {
	
	public static void revertMatrix(int[][] matrix, int num){
		if(matrix == null || matrix.length == 0) return;
		int m = matrix.length;
		int n = matrix[0].length;
		if(num > m * n) return;
		List<Integer> list = new ArrayList<>();
		Set<String> set = new HashSet<>(); 
		helper(matrix, 0, num, list, set);
	}
	
	private static void helper(int[][] matrix, int pos, int num, List<Integer> list, Set<String> set){
		int m = matrix.length;
		int n = matrix[0].length;
		if(num == 0){
			String str = convert(list);
			if(!set.contains(str)){
				addRecord(set, list, m, n);
				print(matrix);
			}
			return;
		}
		for(int i = pos; i < m * n; i++){
			int I = i / n;
			int J = i % n;
			matrix[I][J] = 1;
			list.add(i);
			helper(matrix, i + 1, num - 1, list, set);
			list.remove(list.size() - 1);
			matrix[I][J] = 0;
		}
	}
	
	private static String convert(List<Integer> list){
		StringBuilder sb = new StringBuilder();
		for(Integer num : list){
			sb.append("/" + num);
		}
		return sb.toString();
	}
	
	private static void addRecord(Set<String> set, List<Integer> list, int m, int n){
		List<int[]> points = new ArrayList<int[]>(); 
		for(int num : list){
			int I = num / n;
			int J = num % n;
			points.add(new int[]{I, J});
		}
		// 1 (x, n - y - 1)
		StringBuilder sb = new StringBuilder();
		for(int[] point : points){
			int I = point[0];
			int J = n - point[1] - 1;
			sb.append("/" + (I * n + J));
		}
		set.add(sb.toString());
		sb = new StringBuilder();
		for(int[] point : points){
			int I = m - point[0] - 1;
			int J = point[1];
			sb.append("/" + (I * n + J));
		}
		set.add(sb.toString());
		sb = new StringBuilder();
		for(int[] point : points){
			int I = m - point[0] - 1;
			int J = n - point[1] - 1;
			sb.append("/" + (I * n + J));
		}
		set.add(sb.toString());
	}
	
	private static void print(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static void main(String[] args){
		int[][] matrix = {{0,0,0}, {0,0,0}, {0,0,0}};
		revertMatrix(matrix, 1);
	}
}
