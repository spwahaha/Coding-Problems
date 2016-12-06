package fb;
import java.util.*;
import leetcode.ListNode;
import leetcode.Utilis;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;
        ListNode node = head;
        while(slow != null){
            if(slow.val != node.val) return false;
            slow = slow.next;
            node = node.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverse(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
    
    public boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            list.add(node.val);
            node = node.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while(i < j){
            if(!list.get(i++).equals(list.get(j--))) return false;
        }
        return true;
    }
    
    
    static ListNode start;
    public static boolean isPalindrome3(ListNode head) {
        if(head == null || head.next == null) return true;
        start = head;
        return helper(head);
    }
    
    private static boolean helper(ListNode head){
        if(head == null) return true;
        boolean isPal = helper(head.next);
        if(!isPal) return false;
        if(start.val != head.val) return false;
//        if(head == start) return true;
        start = start.next;
        return true;
    }
    
    public static void main(String[] args){
    	ListNode head = Utilis.generateListNode(new int[]{-16557,-8725,-29125,28873,-21702,15483,-28441,-17845,-4317,-10914,-10914,-4317,-17845,-28441,15483,-21702,28873,-29125,-8725,-16557});
    	System.out.println(isPalindrome3(head));
    }
}
