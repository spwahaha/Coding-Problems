package fb;

import leetcode.TreeNode;
import java.util.*;
/**
 * Created by Christina on 2/29/16.
 */
public class PrintLongestPathOfTree {
	public static void printLogestPath(TreeNode node){
		if(node == null) return;
		List<Integer> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		getLongestPath(node, list, res);
		printList(res);
	}
	
	private static void getLongestPath(TreeNode node, List<Integer> list, List<Integer> res){
		if(node == null) {
			if(list.size() > res.size()){
				res.clear();
				res.addAll(list);
			}
			return;
		}
		list.add(node.val);
		getLongestPath(node.left, list, res);
		getLongestPath(node.right, list, res);
		list.remove(list.size() - 1);
	}
	
	private static void printList(List<Integer> res){
		for(int i = 0; i < res.size(); i++){
			if(i == res.size() - 1){
				System.out.print(res.get(i));
			}else{
				System.out.print(res.get(i) + "->");
			}
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		printLogestPath(root);
	}
	
}
