package leetcode;

public class Utilis {
	public static void printArray(int[] nums){
		for(int num : nums) System.out.print(num + " ");
	}
	
	public static void printArray(int[][] nums){
		for(int[] num : nums){
			for(int n : num) System.out.print(n + " ");
			System.out.println();
		}
	}
	
	public static void printArray(char[][] nums){
		for(char[] num : nums){
			for(char n : num) System.out.print(n + " ");
			System.out.println();
		}
	}
}
