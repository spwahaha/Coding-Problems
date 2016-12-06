package fb;

import leetcode.TreeNode;
import leetcode.Utilis;

public class ConvertSortedArrayToBinarySearchTree {
	/*
	 * convert sorted array to bst with the min height
	 * tree to be balance
	 * every time use the mid element as root
	 * recursive
	 */
	
	public static TreeNode sortedArrayToBST(int[] nums){
		if(nums == null || nums.length == 0) return null;
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}
	
	public static TreeNode sortedArrayToBST(int[] nums, int l, int r){
		if(l > r) return null;
		if(l == r) return new TreeNode(nums[l]);
		int mid = l + (r - l) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, l, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, r);
		return root;
	}
	
    public static void main(String[] args) {
        System.out.println(
        		Utilis.validateBST(sortedArrayToBST(new int[]{1, 2, 4, 6, 7})));
    }
	
	
}
