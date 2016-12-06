package microsoft;

import leetcode.TreeNode;

public class InorderSuccessorInBST {
	//https://leetcode.com/problems/inorder-successor-in-bst/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(p.val >= root.val){
            return inorderSuccessor(root.right, p);
        }else{
            TreeNode left = inorderSuccessor(root.left, p);
            return left != null ? left : root;
        }
    }
    
    
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while(root != null){
            if(p.val < root.val){
                successor = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return successor;
    }
}
