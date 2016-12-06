package leetcode;

public class LowestCommonAncestorOfaBinaryTree {
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
        System.out.println(lowestCommonAncestor(root, root.left.left, root.left.right).val);
    }
}
