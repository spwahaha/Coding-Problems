package microsoft;

import leetcode.ListNode;
import leetcode.Utilis;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
    
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    public static void main(String[] args){
    	ListNode head = Utilis.generateListNode(new int[]{1,2,3,4,5});
    	System.out.println(reverseList(head));
    }
}
