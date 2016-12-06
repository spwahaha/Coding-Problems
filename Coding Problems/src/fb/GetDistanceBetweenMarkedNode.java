package fb;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import leetcode.TreeNode;

public class GetDistanceBetweenMarkedNode {
	
    public static int getDis(TreeNode root) {
    	TreeNode[] nodes = new TreeNode[2];
    	int index = 0;
    	Map<TreeNode, Integer> map = new HashMap<>();
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	int level = 0;
    	while(!q.isEmpty()){
    		int size = q.size();
    		for(int i = 0; i < size; i++){
    			TreeNode node = q.poll();
    			if(node.marked){
    				nodes[index++] = node;
    			} 
    			map.put(node, level);
    			if(node.left != null) q.add(node.left);
    			if(node.right != null) q.add(node.right);
    		}
    		level++;
    	}
    	TreeNode ancestor = lowestCommonAncestor(root, nodes[0], nodes[1]);
    	int res = 0;
    	for(TreeNode node : nodes){
    		res += map.get(node) - map.get(ancestor);
    	}
    	return res;
    }
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if(l != null && r != null) return root;
        if(l == null) return r;
        if(r == null) return l;
        return null;
    }
    
    /*
     *                     1
     *               2             5
     *           3       4               6   
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.marked = true;
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.marked = true;
        System.out.println(getDis(root));
    }

}
