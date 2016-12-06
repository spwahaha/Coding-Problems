package fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;


public class AverageValueByLevelInaTree {
	
    public static List<Integer> averageValueByLevelInaTree(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(root == null) return null;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	while(!q.isEmpty()){
    		int size = q.size();
    		int sum = 0;
    		for(int i = 0; i < size; i++){
    			TreeNode node = q.poll();
    			sum += node.val;
    			if(node.left != null) q.add(node.left);
    			if(node.right != null) q.add(node.right);
    		}
    		res.add(sum / size);
    	}
    	return res;
    }
    
    public static void main(String[] arg) {
        AverageValueByLevelInaTree a = new AverageValueByLevelInaTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        System.out.println(a.averageValueByLevelInaTree(root));
    }
    
}
