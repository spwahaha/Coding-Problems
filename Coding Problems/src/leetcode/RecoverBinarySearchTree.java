package leetcode;

public class RecoverBinarySearchTree {
	//https://leetcode.com/problems/recover-binary-search-tree/
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    private void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        if(firstElement == null && pre.val > root.val){
            firstElement = pre;
        }
        if(firstElement != null && pre.val > root.val){
            secondElement = root;
        }
        pre = root;
        traverse(root.right);
    }
}
