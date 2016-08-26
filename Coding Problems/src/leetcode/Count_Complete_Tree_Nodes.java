package leetcode;

public class Count_Complete_Tree_Nodes {
	//https://leetcode.com/problems/count-complete-tree-nodes/
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lheight = leftHeight(root);
        int rheight = rightHeight(root);
        if(lheight == rheight) return (1 << lheight) - 1;
        else return countNodes(root.left) + countNodes(root.right) + 1; 
    }
    
    private int leftHeight(TreeNode root){
        if(root == null) return 0;
        int h = 0;
        while(root != null){
            h++;
            root = root.left;
        }
        return h;
    }
    
    private int rightHeight(TreeNode root){
        if(root == null) return 0;
        int h = 0;
        while(root != null){
            h++;
            root = root.right;
        }
        return h;
    }
}
