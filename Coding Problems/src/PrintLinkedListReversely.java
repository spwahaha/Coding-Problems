import java.util.ArrayList;
import java.util.List;

import leetcode.ListNode;
import leetcode.TreeNode;

public class PrintLinkedListReversely {

    public void printLinkedListReversely(ListNode head) {
    	if(head == null) return;
    	printLinkedListReversely(head.next);
    	System.out.println(head.val);
    }
    
    public void printLinkedListReversely2(ListNode head) {
    	List<Integer> list = new ArrayList<>();
    	ListNode node = head;
    	while(node != null){
    		list.add(node.val);
    		node = node.next;
    	}
    	for(int i = list.size() - 1; i >= 0; i--){
    		System.out.println(list.get(i));
    	}
    }

    
    public static void main(String[] arg) {
        PrintLinkedListReversely a = new PrintLinkedListReversely();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        a.printLinkedListReversely(head);
        a.printLinkedListReversely2(head);
    }

}
