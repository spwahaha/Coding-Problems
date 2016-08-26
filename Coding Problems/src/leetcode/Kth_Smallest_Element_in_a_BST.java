package leetcode;

import java.util.Stack;

public class Kth_Smallest_Element_in_a_BST {
	//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    int res = 0;
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }
    
    private void inorder(TreeNode root, int k){
        if(root == null) return;
        inorder(root.left, k);
        cnt++;
        if(cnt == k) res = root.val;
        inorder(root.right, k);
    }
    
    
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            k--;
            cur = stack.pop();
            if(k == 0) return cur.val;
            cur = cur.right;
        }
        return -1;
    }
    
}
