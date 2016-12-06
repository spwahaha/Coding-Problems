package fb;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode;

public class MinDepthOfBinaryTree {
	/*
	 * DFS
	 */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        if(root.right == null){
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    
    /*
     * BFS
     */
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left == null && node.right == null) return depth;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}
