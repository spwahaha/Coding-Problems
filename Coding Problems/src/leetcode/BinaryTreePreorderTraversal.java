package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	//https://leetcode.com/problems/binary-tree-preorder-traversal/
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
            list.add(node.val);
        }
        return list;
    }
    
  public static void main(String[] args){
	  TreeNode root = new TreeNode(1);
	  root.left = new TreeNode(2);
	  root.right = new TreeNode(3);
	  root.left.left = new TreeNode(4);
	  System.out.println(preorderTraversal(root));
  }
}
