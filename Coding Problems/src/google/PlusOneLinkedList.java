package google;

import leetcode.ListNode;

public class PlusOneLinkedList {
	//https://leetcode.com/problems/plus-one-linked-list/
    public ListNode plusOne(ListNode head) {
        if(head == null) return null;
        int car = nextPlusOne(head);
        if(car == 0) return head;
        else{
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }
    
    private int nextPlusOne(ListNode head){
        if(head == null) return 1;
        int car = nextPlusOne(head.next);
        head.val += car;
        car = head.val / 10;
        head.val %= 10;
        return car;
    }
    
    
    public ListNode plusOne2(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNotNine = dummy;
        ListNode node = head;
        while(node != null){
            if(node.val != 9){
                lastNotNine = node;
            }
            node = node.next;
        }
        
        lastNotNine.val += 1;
        node = lastNotNine.next;
        while(node != null){
            node.val = 0;
            node = node.next;
        }
        return dummy.val == 1 ? dummy : dummy.next;
    }
}
