package microsoft;

import leetcode.ListNode;

public class IntersectionOfTwoLinkedLists {
	//https://leetcode.com/problems/intersection-of-two-linked-lists/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int len1 = len(headA);
        int len2 = len(headB);
        while(len1 > len2){
            headA = headA.next;
            len1--;
        }
        while(len2 > len1){
            headB = headB.next;
            len2--;
        }
        while(headA != null && headB != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    private int len(ListNode node){
        if(node == null) return 0;
        int len = 0;
        while(node != null){
            node = node.next;
            len++;
        }
        return len;
    }
}
