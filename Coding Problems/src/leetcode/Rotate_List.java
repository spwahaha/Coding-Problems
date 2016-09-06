package leetcode;

public class Rotate_List {
	//https://leetcode.com/problems/rotate-list/
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int len = length(head);
        int move = k % len;
        if(move == 0) return head;
        move = len - move - 1;
        ListNode node = head;
        while(move > 0){
            node = node.next;
            move--;
        }
        ListNode newHead = node.next;
        node.next = null;
        node = newHead;
        while(node.next != null) node = node.next;
        node.next = head;
        return newHead;
    }
    
    private static int length(ListNode head){
        int cnt = 0;
        while(head != null){
            cnt++;
            head = head.next;
        }
        return cnt;
    }
    
    public static ListNode rotateRight2(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode node = head;
        int len = 1;
        while(node.next != null){
            len++;
            node = node.next;
        }
        if(k % len == 0) return head;
        node.next = head;
        node = head;
        for(int i = 0; i < len - k % len - 1; i++){
            node = node.next;
        }
        head = node.next;
        node.next = null;
        return head;
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2,3,4,5};
    	for(int i = 0; i <= nums.length; i++){
    		ListNode head = Utilis.generateListNode(nums);
    		System.out.println(rotateRight(head, i));
    	}
    	System.out.println("-----------------------------------");
    	for(int i = 0; i <= nums.length; i++){
    		ListNode head = Utilis.generateListNode(nums);
    		System.out.println(rotateRight2(head, i));
    	}
    }
}
