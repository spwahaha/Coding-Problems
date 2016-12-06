package fb;

import leetcode.ListNode;
import leetcode.Utilis;

public class ReverseNodesInKGroup {
	//https://leetcode.com/problems/reverse-nodes-in-k-group/
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int cnt = 0;
        while(cur != null && cnt != k){
            cur = cur.next;
            cnt++;
        }
        if(cnt == k){
            cur = reverseKGroup(cur, k);
            while(k-- > 0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        
        return head;
    }
    
    public static void main(String[] args){
    	ListNode head = Utilis.generateListNode(new int[]{1,2,3,4,5,6});
    	System.out.println(reverseKGroup(head, 6));
    }
}
