package leetcode;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public boolean marked;
	public TreeNode(int val){
		this.val = val;
	}
	
	public String toString(){
		return this.val + "";
	}
}
