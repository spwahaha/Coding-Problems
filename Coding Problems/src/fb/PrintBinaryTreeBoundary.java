package fb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import leetcode.TreeNode;

public class PrintBinaryTreeBoundary {
    public List<Integer> printBinaryBoundary(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	if(root == null) return res;
    	List<TreeNode> right = new ArrayList<>();
    	List<TreeNode> leaves = new ArrayList<>();
    	List<TreeNode> left = new LinkedList<>();
    	leaves = getLeaves(root);
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	while(!q.isEmpty()){
    		int size = q.size();
    		left.add(0, q.peek());
    		for(int i = 0; i < size; i++){
    			TreeNode node = q.poll();
    			if(i == size - 1) right.add(node);
    			if(node.left != null) q.add(node.left);
    			if(node.right != null) q.add(node.right);
    		}
    	}
    	System.out.println(right);
    	System.out.println(leaves);
    	System.out.println(left);

    	right.addAll(leaves);
    	right.addAll(left);
    	Set<TreeNode> visited = new HashSet<>();
    	for(TreeNode node : right){
    		if(visited.contains(node)) continue;
    		res.add(node.val);
    		visited.add(node);
    	}
    	return res;
    }
    
    private List<TreeNode> getLeaves(TreeNode root){
    	List<TreeNode> list = new ArrayList<>();
    	if(root == null) return list;
    	if(root.left == null && root.right == null){
    		list.add(root);
    		return list;
    	}
    	List<TreeNode> left = getLeaves(root.left);
    	List<TreeNode> right = getLeaves(root.right);
    	right.addAll(left);
    	return right;
    }
    
    public static void main(String[] args) {
        PrintBinaryTreeBoundary a = new PrintBinaryTreeBoundary();
        /**
         * *        7
         *      3      6
         *    2   4
         *  1  5    8
         *  */

        TreeNode root = new TreeNode(7);
        root.right = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(8);
        root.left.left.right = new TreeNode(5);

        System.out.println(a.printBinaryBoundary(root));

    }

}
