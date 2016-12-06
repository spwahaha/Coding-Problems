package fb;
import java.util.*;

import leetcode.TreeNode;

public class PreorderTraversal {
	//https://leetcode.com/problems/binary-tree-preorder-traversal/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        return list;
    }
    
}
