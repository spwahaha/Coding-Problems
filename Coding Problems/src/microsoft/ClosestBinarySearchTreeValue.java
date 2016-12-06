package microsoft;

import leetcode.TreeNode;

public class ClosestBinarySearchTreeValue {
	//https://leetcode.com/problems/closest-binary-search-tree-value/
    public int closestValue(TreeNode root, double target) {
        if(root == null) return Integer.MAX_VALUE;
        TreeNode kid = target < root.val ? root.left : root.right;
        if(kid == null) return root.val;
        int val = closestValue(kid, target);
        return Math.abs(val - target) < Math.abs(root.val - target) ? val : root.val;
    }
    
    
}
