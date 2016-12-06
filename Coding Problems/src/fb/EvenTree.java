package fb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EvenTree {
	public static class TreeNode{
		int val;
		Set<TreeNode> children;
		public TreeNode(int val){
			this.val = val;
			this.children = new HashSet<>();
		}
		
		public String toString(){
			StringBuilder sb = new StringBuilder();
			traverse(this, sb);
			return sb.toString();
		}
		
		private void traverse(TreeNode root, StringBuilder sb){
			if(root == null) return;
			sb.append(root.val + "  ");
			for(TreeNode child : root.children){
				traverse(child, sb);
			}
		}
		
	}
	
	public static List<TreeNode> breakTrees(TreeNode root){
		List<TreeNode> res = new ArrayList<>();
		if(root == null) return res;
		countNodes(res, root);
		res.add(root);
		return res;
	}
	
	private static int countNodes(List<TreeNode> res, TreeNode root){
		if(root == null) return 0;
		if(root.children.size() == 0) return 1;
		int cnt = 0;
		Set<TreeNode> remove = new HashSet<>();
		for(TreeNode child : root.children){
			int count = countNodes(res, child);
			if(count % 2 == 0){
				remove.add(child);
				res.add(child);
			}else{
				cnt += count;
			}
		}
		for(TreeNode rem : remove){
			root.children.remove(rem);
		}
		return cnt + 1;
	}
	
	
	public static void main(String[] args){
		TreeNode n6 = new TreeNode(6);
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		n2.children.add(n6);
		n1.children.add(n2);
		n1.children.add(n3);
		n1.children.add(n4);
		n1.children.add(n5);
		List<TreeNode> res = breakTrees(n1);
		System.out.println(res);
	}
}
