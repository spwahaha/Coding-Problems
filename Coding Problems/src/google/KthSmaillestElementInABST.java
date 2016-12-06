package google;
import java.util.*;

import leetcode.TreeNode;

public class KthSmaillestElementInABST {
//	https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            k--;
            if(k == 0) return cur.val;
            cur = cur.right;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        return 0;
    }
}
