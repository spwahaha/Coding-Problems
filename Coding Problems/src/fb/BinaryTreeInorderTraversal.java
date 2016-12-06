package fb;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

public class BinaryTreeInorderTraversal {
	//https://leetcode.com/problems/binary-tree-inorder-traversal/
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        while(!stack.isEmpty()){
            node = stack.pop();
            list.add(node.val);
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return list;
    }
    
    public static void main(String[] arg) {
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
}
}
