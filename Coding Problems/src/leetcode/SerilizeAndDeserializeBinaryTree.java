package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerilizeAndDeserializeBinaryTree {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null").append(",");
        }else{
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return deserialize(q);
    }
    
    private TreeNode deserialize(Queue<String> q){
        String str = q.poll();
        if(str.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;
    }
    
    
    public String serialize2(TreeNode root) {
        if(root == null) return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(root.val + ",");
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.add(node.left);
                sb.append(node.left.val).append(",");
            }else{
                sb.append("null").append(",");
            }
            if(node.right != null){
                q.add(node.right);
                sb.append(node.right.val).append(",");
            }else{
                sb.append("null").append(",");
            }
        }
        String str = sb.toString();
        return str.substring(0, str.length() - 1);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        if(q.peek().equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(q.poll()));
        Queue<TreeNode> nodeq = new LinkedList<>();
        nodeq.add(root);
        while(!nodeq.isEmpty()){
            TreeNode node = nodeq.poll();
            String str = q.poll();
            if(!str.equals("null")){
                node.left = new TreeNode(Integer.parseInt(str));
                nodeq.add(node.left);
            }
            str = q.poll();
            if(!str.equals("null")){
                node.right = new TreeNode(Integer.parseInt(str));
                nodeq.add(node.right);
            }
        }
        return root;
    }
}
