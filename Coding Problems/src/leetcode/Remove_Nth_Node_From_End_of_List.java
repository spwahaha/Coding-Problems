package leetcode;

public class Remove_Nth_Node_From_End_of_List {
	//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = length(head);
        int cnt = len - n;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = dummy;
        while(cnt > 0){
            node = node.next;
            cnt--;
        }
        node.next = node.next.next;
        return dummy.next;
    }
    
    private static int length(ListNode head){
        int cnt = 0;
        while(head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
    
    public static void main(String[] args){
    	ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(2);
    	ListNode node3 = new ListNode(3);
    	node1.next = node2;
    	node2.next = node3;
    	System.out.println(removeNthFromEnd(node1, 2));
    }
}
