package google;

import leetcode.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        maxLen = 0;
        helper(root, null, 0);
        return maxLen;
    }
    
    private void helper(TreeNode root, Integer parentVal, int len){
        maxLen = Math.max(len, maxLen);
        if(root == null) return;
        if(parentVal != null && parentVal + 1 == root.val){
            helper(root.left, root.val, len + 1);
            helper(root.right, root.val, len + 1);
        }else{
            helper(root.left, root.val, 1);
            helper(root.right, root.val, 1);
        }
        
    }
    
    
}
