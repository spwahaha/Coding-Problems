package leetcode;

public class Add_Two_Numbers {
	//https://leetcode.com/problems/add-two-numbers/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(sum % 10);
            node = node.next;
            carry = sum / 10;
        }
        if(carry != 0) node.next = new ListNode(carry);
        return dummy.next;
    }
    
    public static void main(String[] args){
    	ListNode[] nodes1 = new ListNode[3];
    	ListNode[] nodes2 = new ListNode[3];
    	nodes1[0] = new ListNode(2);
    	nodes1[1] =  new ListNode(4);
    	nodes1[2] = new ListNode(3);
    	nodes1[0].next = nodes1[1];
    	nodes1[1].next = nodes1[2];
    	nodes2[0] = new ListNode(5);
    	nodes2[1] = new ListNode(6);
    	nodes2[2] = new ListNode(4);
    	nodes2[0].next = nodes2[1];
    	nodes2[1].next = nodes2[2];
    	// 2->4->3 + 5->6->4
    	ListNode res = addTwoNumbers(nodes1[0], nodes2[0]);
    	while(res != null){
    		System.out.print(res.val + "->");
    		res = res.next;
    	} 
    	System.out.println("null");
    }
}
