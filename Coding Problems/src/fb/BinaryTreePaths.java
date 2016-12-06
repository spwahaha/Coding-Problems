package fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcode.TreeNode;


public class BinaryTreePaths {
	//https://leetcode.com/problems/binary-tree-paths/
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        
        if(root == null) return res;
        if(root.left == null && root.right == null){
            res.add(root.val + "");
            return res;
        }
        
        if(root.left != null){
            for(String str : binaryTreePaths(root.left)){
                res.add(root.val + "->" + str);
            }
        }
        
        if(root.right != null){
            for(String str : binaryTreePaths(root.right)){
                res.add(root.val + "->" + str);
            }
        }
        return res;
    }
    
    public static List<String> binaryTreePathsBFS(TreeNode root){
    	List<String> res = new ArrayList<String>();
    	if(root == null) return res;
    	Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    	Queue<String> pathQueue = new LinkedList<String>();
    	nodeQueue.add(root);
    	pathQueue.add(root.val + "");
    	while(!nodeQueue.isEmpty()){
    		TreeNode node = nodeQueue.poll();
    		String path = pathQueue.poll();
    		if(node.left == null && node.right == null){
    			res.add(path);
    		}
    		
    		if(node.left != null){
    			nodeQueue.add(node.left);
    			pathQueue.add(path + "->" + node.left.val);
    		}
    		
    		if(node.right != null){
    			nodeQueue.add(node.right);
    			pathQueue.add(path + "->" + node.right.val);
    		}
    	}
    	return res;    	
    }
    
	public static List<String> binaryTreePathsStack(TreeNode root){
		List<String> res = new ArrayList<String>();
		if(root == null) return res;
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		Stack<String> pathStack = new Stack<String>();
		TreeNode node = root;
		String path = node.val + "";
		nodeStack.push(node);
		pathStack.push(path);
		node = node.left;
		while(node != null){
			path = path + "->" + node.val;
			nodeStack.push(node);
			pathStack.push(path);
			node = node.left;
		}
		
		while(!nodeStack.isEmpty()){
			node = nodeStack.pop();
			path = pathStack.pop();
			if(node.left == null && node.right == null){
				res.add(path);
			}
			node = node.right;
			while(node != null){
				path += "->" + node.val;
				nodeStack.push(node);
				pathStack.push(path);
				node = node.left;
			}
		}
		return res;
	}
    
    
    public static List<String> binaryTreePaths3(TreeNode root) {
        List<String> res = new ArrayList<>();
        getPath(root, "", res);
        return res;
    }
    
    private static void getPath(TreeNode root, String cur, List<String> list){
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add(cur + root.val);
            return;
        }
        getPath(root.left, cur + root.val + "->",  list);
        getPath(root.right, cur + root.val + "->", list);
    }
    
    public static void main(String[] arg) {
//                          1
//                        /   \
//                        2    3
//                         \
//                          4
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        System.out.println(binaryTreePaths(treeNode));
        System.out.println(binaryTreePathsBFS(treeNode));
        System.out.println(binaryTreePathsStack(treeNode));
        System.out.println(binaryTreePaths3(treeNode));
    }
}
