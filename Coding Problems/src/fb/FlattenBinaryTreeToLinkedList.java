package fb;

import java.util.Stack;

import leetcode.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
	
	/*
	 * root, left, right. preorder
	 * then connect the the next node in stack as right, set left null
	 * T: O(n), S: O(height)
	 */
    public static void flatten(TreeNode root) {
        if(root == null) return;
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
            node.right = null;
            node.left = null;
            if(!stack.isEmpty()){
                node.right = stack.peek();
            }
        }
    }
    
    /*
     * recursive, flatten right, flatten left
     * pre is the last flattened node
     *                     1
     *               2             5
     *           3       4               6   
     * The order of being pre is: 6, 5, 4, 3, 1
     */
    static TreeNode pre;
    public static void flatten2(TreeNode root) {
        if(root == null) return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
//        flatten(root);
        flatten2(root);
        System.out.println();

    }
}
