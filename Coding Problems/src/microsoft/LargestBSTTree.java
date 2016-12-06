package microsoft;

import leetcode.TreeNode;

public class LargestBSTTree {
	//https://leetcode.com/problems/largest-bst-subtree/
    class Result{
        int size;
        int max;
        int min;
        public Result(int size, int max, int min){
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        traverse(root);
        return max;
    }
    
    private Result traverse(TreeNode root){
        if(root == null) return new Result(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Result left = traverse(root.left);
        Result right = traverse(root.right);
        if(left.size == -1 || right.size == -1 || left.max >= root.val || right.min <= root.val){
            return new Result(-1, 0, 0);
        }
        int size = left.size + right.size + 1;
        max = Math.max(max, size);
        return new Result(size, Math.max(right.max, root.val), Math.min(left.min, root.val));
    }
}
