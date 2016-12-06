package fb;

import java.util.Stack;

import leetcode.TreeNode;

public class BSTIterator {
	//https://leetcode.com/problems/binary-search-tree-iterator/
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        putAllLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int res = node.val;
        putAllLeft(node.right);
        return res;
    }
    
    private void putAllLeft(TreeNode node){
    	while(node != null){
    		stack.push(node);
    		node = node.left;
    	}
    }
    
    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        BSTIterator a = new BSTIterator(root);
        while (a.hasNext()) {
            System.out.println(a.next());
        }
    }
}
