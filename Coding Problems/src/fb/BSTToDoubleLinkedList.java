package fb;

import java.util.*;

import leetcode.TreeNode;

public class BSTToDoubleLinkedList {

	// new DoubleLinkedList using Stack, inorder
    public DoubleLinkedNode convert(TreeNode root) {
    	if(root == null) return null;
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode node = root;
    	putAllLeft(node, stack);
    	DoubleLinkedNode head = null;
    	DoubleLinkedNode pre = null;
    	while(!stack.isEmpty()){
    		node = stack.pop();
    		DoubleLinkedNode doubleNode = new DoubleLinkedNode(node.val);
//        	System.out.print(node.val + " ");
    		if(pre == null){
    			head = doubleNode;
    		}else{
    			pre.next = doubleNode;
    			doubleNode.pre = pre;
    		}
    		pre = doubleNode;
    		node = node.right;
    		putAllLeft(node, stack);
    	}
    	System.out.println();
    	return head;
    }
    
    private void putAllLeft(TreeNode root, Stack<TreeNode> stack){
    	while(root != null){
    		stack.push(root);
    		root = root.left;
    	}
    }
    
    // DoubleLinkedList dfs inorder
    public DoubleLinkedNode convert2(TreeNode root) {
    	DoubleLinkedNode[] nodes = dfs(root);
    	return nodes == null ? null : nodes[0];
    }
    
    private DoubleLinkedNode[] dfs(TreeNode root){
    	if(root == null) return null;
    	if(root.left == null && root.right == null){
    		DoubleLinkedNode node = new DoubleLinkedNode(root.val);
    		return new DoubleLinkedNode[]{node, node};
    	}
    	DoubleLinkedNode[] left = dfs(root.left);
    	DoubleLinkedNode[] right = dfs(root.right);
    	DoubleLinkedNode node = new DoubleLinkedNode(root.val);
    	DoubleLinkedNode head = node;
    	DoubleLinkedNode tail = node;
    	if(left != null){
    		head = left[0];
    		left[1].next = node;
    		node.pre = left[1];
    	}
    	if(right != null){
    		tail = right[1];
    		node.next = right[0];
    		right[0].pre = node;
    	}
    	
    	return new DoubleLinkedNode[] {head, tail};
    }
    
    /*
     * result is also tree, just change pointer directly
     */
    public TreeNode convert3(TreeNode root){
    	if(root == null) return null;
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode node = root;
    	putAllLeft(node, stack);
    	node = stack.pop();
    	TreeNode head = node;
    	TreeNode tail = head;
    	
    	node = node.right;
    	putAllLeft(node, stack);
    	while(!stack.isEmpty()){
    		node = stack.pop();
    		tail.right = node;
    		node.left = tail;
    		tail = tail.right;
    		
    		node = node.right;
        	putAllLeft(node, stack);
    	}
    	return head;
    }
    
    public TreeNode convert4(TreeNode root){
    	TreeNode[] nodes = convert4Helper(root);
    	return nodes == null ? null : nodes[0];
    }
    
    private TreeNode[] convert4Helper(TreeNode root){
    	if(root == null)return null;
    	if(root.left == null || root.right == null){
    		return new TreeNode[]{root, root};
    	}
    	TreeNode[] left = convert4Helper(root.left);
    	TreeNode[] right = convert4Helper(root.right);
    	TreeNode head = root; TreeNode tail = root;
    	if(left != null){
    		head = left[0];
    		left[1].right = root;
    		root.left = left[1];
    	}
    	if(right != null){
    		tail = right[1];
    		right[1].left = root;
    		root.right = right[0];
    	}
    	return new TreeNode[]{head, tail};
    }
    
    public static void main(String[] args){
    	BSTToDoubleLinkedList bstToDLN = new BSTToDoubleLinkedList();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);
//        a.convert(root);
//        a.convert1(root);
        System.out.println(bstToDLN.convert(root));
        System.out.println(bstToDLN.convert2(root));
        bstToDLN.convert3(root);
//        bstToDLN.convert4(root);
        
    }

}
