package fb;

import leetcode.TreeNode;

public class ConvertArrayToMinHeap {
	/*
	 * convert an array to min heap, use treenode represent node
	 */
	public static TreeNode convert(int[] nums){
		return convert(nums, 0, nums.length - 1);
	}
	
	private static TreeNode convert(int[] nums, int l, int r){
		if(l > r) return null;
		if(l == r) return new TreeNode(nums[l]);
		int min = nums[l], minIndex = l;
		for(int i = l; i <= r; i++){
			if(nums[i] < min){
				min = nums[i];
				minIndex = i;
			}
		}
		TreeNode root = new TreeNode(min);
		root.left = convert(nums, l, minIndex - 1);
		root.right = convert(nums, minIndex + 1, r);
		return root;
	}
	
    public static void main(String[] args) {
        TreeNode root = convert(new int[]{9, 4, 6, 2, 3, 1, 5, 7});

    }
}
