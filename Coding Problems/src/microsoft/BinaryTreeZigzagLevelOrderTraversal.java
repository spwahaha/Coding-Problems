package microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean l2r = true;
        while(!q.isEmpty()){
        	int size = q.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(l2r) list.add(node.val);
                else list.add(0, node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            l2r = !l2r;
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
