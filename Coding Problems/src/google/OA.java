package google;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class OA {
	/*
	 * replace number with max of two adjacent
	 */
	public static int solution1(int x){
		String ori = "" + x;
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < ori.length(); i++){
			int n1 = ori.charAt(i) - '0';
			int n2 = ori.charAt(i - 1) - '0';
			String pre = ori.substring(0, i - 1);
			String pos = ori.substring(i + 1, ori.length());
			int max = Math.max(n1, n2);
			int val = Integer.parseInt(pre + max + pos);
			min = Math.min(min, val);
		}
		return min;
	}
	
	/*
	 * replace number with the average int
	 */
	public static int solution1_1(int x){
		String ori = "" + x;
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < ori.length(); i++){
			double n1 = (double)(ori.charAt(i) - '0');
			double n2 = (double)(ori.charAt(i - 1) - '0');
			String pre = ori.substring(0, i - 1);
			String pos = ori.substring(i + 1, ori.length());
			int ave = (int) Math.ceil((n1 + n2) / 2);
			int val = Integer.parseInt(pre + ave + pos);
			max = Math.max(max, val);
		}
		return max;
	}
	
	
	static class TreeNode{
		String name;
		Set<TreeNode> children;
		int level;
		TreeNode parent;
		boolean isFile(){
			return name.contains(".");
		}
		boolean isImageFile(){
			return name.endsWith(".jpeg") ||
					name.endsWith(".png") ||
					name.endsWith(".gif");
		}
		int length(){
			return this.name.length();
		}
		public TreeNode(String name, int level, TreeNode parent){
			this.name = name;
			this.level = level;
			this.parent = parent;
			this.children = new HashSet<>();
		}
	}
	
	/*
	 * sum of length from root to image file
	 */
	public static int solution2(String str){
		TreeNode root = new TreeNode("", 0, null);
		parseString(root, str);
		return helper2(root, 0);
	}
	
	private static int helper2(TreeNode root, int sum){
		if(root == null) return 0;
		if(root.isImageFile()){
			return sum + root.level + root.length();
		}
		int val = 0;
		for(TreeNode child : root.children){
			val += helper2(child, sum + root.length());
		}
		return val;
	}
	
	/*
	 * longest path to file
	 */
	static int maxLen = 0;
	public static int solution2_1(String str){
		TreeNode root = new TreeNode("", 0, null);
		parseString(root, str);
		helper2_1(root, 0);
		return maxLen;
	}
	
	private static int helper2_1(TreeNode root, int sum){
		if(root == null) return 0;
		if(root.isImageFile()){
			return maxLen = Math.max(maxLen, sum + root.level + root.length());
		}
		int val = 0;
		for(TreeNode child : root.children){
			helper2_1(child, sum + root.length());
		}
		return val;
	}
	
	/*
	 * return longest path to directory
	 */
	static int maxLen_2 = 0;
	public static int solution2_2(String str){
		TreeNode root = new TreeNode("", 0, null);
		parseString(root, str);
		helper2_2(root, 0);
		return maxLen_2;
	}
	
	private static int helper2_2(TreeNode root, int sum){
		if(root == null) return 0;
		if(root.isImageFile()){
			return maxLen_2 = Math.max(maxLen_2, sum + root.level - 1);
		}
		int val = 0;
		for(TreeNode child : root.children){
			helper2_2(child, sum + root.length());
		}
		return val;
	}
	
	
	
	private static void parseString(TreeNode root, String str) {
		// TODO Auto-generated method stub
		TreeNode node = root;
		String[] strs = str.split("\n");
		for(int i = 0; i < strs.length; i++){
			String s = strs[i];
			int j = 0;
			while(s.charAt(j) == ' ') j++;
			int level = j + 1;
			while(node != null && level != node.level + 1){
				node = node.parent;
			}
			TreeNode chil = new TreeNode(s.substring(j), level, node);
			node.children.add(chil);
			node = chil;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		System.out.println(solution1(233614));
		System.out.println(solution1_1(612215));		
		String str = "";
		BufferedReader input = new BufferedReader(new FileReader("./src/google/OAFileStructure.txt"));
		String line = input.readLine();
		while(line != null){
			if(str.equals("")){
				str += line;
			}else{
				str += "\n" + line;
			}
			line = input.readLine();
		}
		
		System.out.println(str);
		System.out.println(solution2(str));  // /dir1/dir12/picture.jpeg(24) + /dir2/file2.gif(15) --> 39
		System.out.println(solution2_1(str)); // /dir1/dir12/picture.jpeg --> 24
		System.out.println(solution2_2(str)); // /dir1/dir12/  --> 12
	}
}
