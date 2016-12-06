package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
	// Leetcode 314
    public static List<List<Integer>> verticalOrder(TreeNode root) {
    	if(root == null) return new ArrayList<>();
    	Queue<TreeNode> nodeQueue = new LinkedList<>();
    	Queue<Integer> indexQueue = new LinkedList<>();
    	List<List<Integer>> right = new ArrayList<>();
    	List<List<Integer>> left = new ArrayList<>();
    	nodeQueue.add(root);
    	indexQueue.add(0);
    	while(!nodeQueue.isEmpty()){
    		TreeNode node = nodeQueue.poll();
    		int index = indexQueue.poll();
    		if(node.left != null){
    			nodeQueue.add(node.left);
    			indexQueue.add(index - 1);
    		}
    		if(node.right != null){
    			nodeQueue.add(node.right);
    			indexQueue.add(index + 1);
    		}
    		if(index >= 0){
    			if(index == right.size()){
    				right.add(new ArrayList<Integer>(Arrays.asList(node.val)));
    			}else{
    				right.get(index).add(node.val);
    			}
    		}else{
    			index = - index - 1;
    			if(index == left.size()){
    				left.add(new ArrayList<Integer>(Arrays.asList(node.val)));
    			}else{
    				left.get(index).add(node.val);
    			}
    		}
    	}
    	Collections.reverse(left);
    	left.addAll(right);
    	return left;
    }
    

    
    
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);
        System.out.println(verticalOrder(root));
    }

}
