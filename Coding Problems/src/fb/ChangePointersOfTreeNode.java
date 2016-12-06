package fb;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode;

public class ChangePointersOfTreeNode {
	public static TreeNode changePointers(TreeNode root){
		if(root == null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			TreeNode head = queue.peek();
			for(int i = 0; i < size; i++){
				TreeNode node = queue.poll();
				if(node.left != null){
					queue.add(node.left);
					node.left = null;
				} 
				if(node.right != null) queue.add(node.right);
				node.right = i == size - 1 ? null : queue.peek();
			}
			head.left = queue.isEmpty() ? null : queue.peek();
		}
		return root;
	}
	
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        changePointers(root);
    }
}
