package fb;

import leetcode.TreeNode;

public class LCAOfDeepestLeaves {
	
	class Tuple{
		int depth;
		TreeNode lca;
		public Tuple(int depth, TreeNode lca){
			this.depth = depth;
			this.lca = lca;
		}
	}
	
	public TreeNode LCAOfDeepestLeaves(TreeNode root){
		Tuple t = find(root, 0);
		return t.lca;
	}
	
	private Tuple find(TreeNode root, int depth){
		if(root == null) {
			return new Tuple(-1, null);
		}
		Tuple lres = find(root.left, depth);
		Tuple rres = find(root.right, depth);
		
		if(lres.depth == rres.depth){
			return new Tuple(lres.depth == -1 ? depth : lres.depth, root);
		}else{
			return new Tuple(Math.max(lres.depth, rres.depth), 
					lres.depth > rres.depth ? lres.lca : rres.lca);
		}
	}
	
	public static void main(String[] args){
		LCAOfDeepestLeaves l = new LCAOfDeepestLeaves();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(l.LCAOfDeepestLeaves(root).val);
	}
	
	
	
	
	
}
