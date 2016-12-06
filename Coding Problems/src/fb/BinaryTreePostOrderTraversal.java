package fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

public class BinaryTreePostOrderTraversal {
	//https://leetcode.com/problems/binary-tree-postorder-traversal/
    // left, right, root
	
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        return list;
    }
    
    private void helper(TreeNode root, List<Integer> list){
        if(root == null) return;
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);
    }
	
    /*
     * reverse: root, right, left
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(0, node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return list;
    }
}
