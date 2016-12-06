package fb;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

public class LargestKElementInBST {
	/*
	 * right, cur, left order
	 * get the first k elements
	 */
	public static List<Integer> largestKElementsinBST(TreeNode root, int k) {
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while(node != null){
			stack.push(node);
			node = node.right;
		}
		while(!stack.isEmpty() && k > 0){
			k--;
			node = stack.pop();
			res.add(node.val);
			node = node.left;
			while(node != null){
				stack.push(node);
				node = node.right;
			}
		}
		return res;
	}
	
	public static List<Integer> largestKElementsinBST2(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		helper(root, list, k);
		return list;
	}
	
	public static void helper(TreeNode root, List<Integer> list, int k){
		if(list.size() >= k) return;
		if(root == null) return;
		helper(root.right, list, k);
		if(list.size() < k) list.add(root.val);
		helper(root.left, list, k);
	}


    public static void main(String[] arg) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        System.out.println(largestKElementsinBST(root, 5));
        System.out.println(largestKElementsinBST(root, 3));
        System.out.println(largestKElementsinBST(root.right, 3));
        System.out.println(largestKElementsinBST(root.right, 5));
        System.out.println(largestKElementsinBST(root.left, 3));
        System.out.println();

        System.out.println(largestKElementsinBST2(root, 5));
        System.out.println(largestKElementsinBST2(root, 3));
        System.out.println(largestKElementsinBST2(root.right, 3));
        System.out.println(largestKElementsinBST2(root.right, 5));
        System.out.println(largestKElementsinBST2(root.left, 3));
        System.out.println();
    }
}
