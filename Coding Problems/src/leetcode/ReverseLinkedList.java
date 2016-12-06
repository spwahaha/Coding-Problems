package leetcode;

public class ReverseLinkedList {
	//https://leetcode.com/problems/reverse-linked-list/
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
    
    public static void reversePrintList(ListNode head){
    	if(head == null) return;
    	reversePrintList(head.next);
    	if(head.next == null)	System.out.print(head.val);
    	else System.out.print("->" + head.val);
    }
    
    public static void main(String[] args){
    	ListNode root = Utilis.generateListNode(new int[]{1,2,3,4,5,6});
    	root = reverseList(root);
    	System.out.println(root);
    	reversePrintList(root);
    }
}
