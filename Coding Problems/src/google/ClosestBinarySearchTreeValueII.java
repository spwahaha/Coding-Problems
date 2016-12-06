package google;

import java.util.*;

import leetcode.TreeNode;

public class ClosestBinarySearchTreeValueII {
	//https://leetcode.com/problems/closest-binary-search-tree-value-ii/
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> pre = new Stack<>();
        Stack<Integer> post = new Stack<>();
        traverse(root, target, pre, true);
        traverse(root, target, post, false);
        
        while(k-- > 0){
            if(post.isEmpty()){
                res.add(pre.pop());
            }else if(pre.isEmpty()){
                res.add(post.pop());
            }else if(Math.abs(post.peek() - target) < Math.abs(pre.peek() - target)){
                res.add(post.pop());
            }else{
                res.add(pre.pop());
            }
        }
        return res;
    }
    
    private void traverse(TreeNode root, double target, Stack<Integer> stack, boolean leftFirst){
        if(root == null) return;
        traverse(leftFirst ? root.left : root.right, target, stack, leftFirst);
        if(leftFirst && root.val >= target) return;
        if(!leftFirst && root.val < target) return;
        stack.push(root.val);
        traverse(leftFirst ? root.right : root.left, target, stack, leftFirst);
    }
}
