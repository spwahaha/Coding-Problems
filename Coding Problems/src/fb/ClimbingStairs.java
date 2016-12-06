package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingStairs {
	
	/*
	 * DP f(n) = f(n - 1) + f(n - 2);
	 */
	public static int climbStairs(int n){
		if(n <= 0) return 0;
		if(n == 1) return 1;
		int step1 = 1;
		int step2 = 2;
		for(int i = 3; i <= n; i++){
			int cur = step1 + step2;
			step1 = step2;
			step2 = cur;
		}
		return step2;
	}
	
	public static List<List<Integer>> climbStairsPaths(int n){
		List<List<Integer>> res = new ArrayList<>();
		if(n <= 0) return res;
		List<List<Integer>> path1 = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1))));
		if(n == 1) return path1;
		List<List<Integer>> path2 = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1,1))));
		path2.add(new ArrayList<>(Arrays.asList(2)));
		for(int i = 3; i <= n; i++){
			List<List<Integer>> cur = new ArrayList<>();
			for(List<Integer> path : path1){
				List<Integer> temp = new ArrayList<Integer>(path);
				temp.add(2);
				cur.add(temp);
			}
			for(List<Integer> path : path2){
				List<Integer> temp = new ArrayList<Integer>(path);
				temp.add(1);
				cur.add(temp);
			}
			path1 = path2;
			path2 = cur;			
		}
		return path2;
	}
	
	
	public static void main(String[] args){
		for(int i = 1; i < 8; i++){
			System.out.println(climbStairs(i));
		}
        System.out.println(climbStairsPaths(2));
        System.out.println(climbStairsPaths(3));
        System.out.println(climbStairsPaths(4));
	}
}
