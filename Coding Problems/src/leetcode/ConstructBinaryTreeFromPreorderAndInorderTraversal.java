package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, map);
    }
    
    private static TreeNode buildTree(int[] inorder, int s1, int e1, int[] preorder, int s2, int e2, Map<Integer, Integer> map){
        if(s1 > e2 || s2 > e2) return null;
        TreeNode root = new TreeNode(preorder[s2]);
        int pos = map.get(preorder[s2]);
        int leftSize = pos - s1;
        root.left = buildTree(inorder, s1, pos - 1, preorder, s2 + 1, s2 + leftSize, map);
        root.right = buildTree(inorder, pos + 1, e1, preorder, s2 + leftSize + 1, e2, map);
        return root;
    }
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.left.right = new TreeNode(3);
    	buildTree(new int[]{1,2,3}, new int[]{2,3,1});
    }
}
