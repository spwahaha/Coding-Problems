package fb;

import leetcode.TreeNode;

public class BalancedBinaryTree {
	//https://leetcode.com/problems/balanced-binary-tree/
	/*
	 * Balanced: left is balanced, right is balanced and height difference is not greater than 1
	 * Use height to represent the whether the tree is balanced:
	 * 1. -1, the tree is not balanced
	 * 2. others, the height of the tree
	 */
    public static boolean isBalanced(TreeNode root) {
        return balancedHeight(root) >= 0;
    }
    
    private static int balancedHeight(TreeNode root){
        if(root == null) return 0;
        int l = balancedHeight(root.left);
        int r = balancedHeight(root.right);
        if(l == -1 || r == -1) return -1;
        if(Math.abs(l - r) > 1) return -1;
        return Math.max(l, r) + 1;
    }
    
    
    
}
