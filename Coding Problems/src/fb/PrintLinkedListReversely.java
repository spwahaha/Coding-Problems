package fb;

import leetcode.ListNode;
import leetcode.Utilis;

public class PrintLinkedListReversely {
	
	public static void printLinkedListReversely(ListNode head){
		if(head == null) return;
		printLinkedListReversely(head.next);
		System.out.println(head.val);
	}
	
	public static void main(String[] args){
		ListNode head = Utilis.generateListNode(new int[]{1,2,3,4,5});
		printLinkedListReversely(head);
	}
}
