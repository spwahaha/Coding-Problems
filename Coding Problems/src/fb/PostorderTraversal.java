package fb;

import java.util.*;

import leetcode.TreeNode;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new LinkedList<>();
    	if(root == null) return list;
    	Stack<TreeNode> stack = new Stack<>();
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode cur = stack.pop();
    		list.add(0, cur.val);
    		if(cur.left != null) stack.push(cur.left);
    		if(cur.right != null) stack.push(cur.right);
    	}
    	return list;
    }

}
