package leetcode;

public class ValidateBST {
    
	public static boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidBST(root.left, (long)Integer.MIN_VALUE - 1, root.val) && isValidBST(root.right, root.val, (long)Integer.MAX_VALUE + 1); 
    }
    
    public static boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
