package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	//https://leetcode.com/problems/binary-tree-level-order-traversal/
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
