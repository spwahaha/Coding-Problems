package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	//https://leetcode.com/problems/binary-tree-inorder-traversal/
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorderTraversal(root, res);
        return res;
    }
    
    private static void inorderTraversal(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
	
	
	
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        
        while(!stack.isEmpty()){
            node = stack.pop();
            res.add(node.val);
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args){
		//      1
		//    /   \
		//    2    3
		//     \
		//      4
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.right = new TreeNode(4);
		
		System.out.println(inorderTraversal(treeNode));
		System.out.println(inorderTraversal2(treeNode));
    }
    
}
