package fb;

import leetcode.ListNode;
import leetcode.TreeNode;
import leetcode.Utilis;

public class ConvertSortedListToBinarySearchTree {
    
	public static TreeNode sortedListToBST(ListNode head) {
    	if(head == null) return null;
    	if(head.next == null) return new TreeNode(head.val);
    	ListNode fast = head;
    	ListNode slow = head;
    	ListNode temp = slow;
    	while(fast != null && fast.next != null){
    		temp = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	ListNode newHead = slow.next;
    	slow.next = null;
    	temp.next = null;
    	TreeNode root = new TreeNode(slow.val);
    	root.left = sortedListToBST(head);
    	root.right = sortedListToBST(newHead);
    	return root;
    }
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5};
		ListNode head = Utilis.generateListNode(nums);
		System.out.println(Utilis.validateBST(sortedListToBST(head)));
	}
}
