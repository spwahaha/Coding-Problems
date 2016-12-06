package google;
import java.util.*;

import leetcode.ListNode;

public class LinkedListRandomNode {
	//https://leetcode.com/problems/linked-list-random-node/
    ListNode head;
    Random rand;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = head;
        int res = 0;
        int cnt = 0;
        while(node != null){
            cnt++;
            int temp = rand.nextInt(cnt);
            if(temp == 0){
                res = node.val;
            }
            node = node.next;
        }
        return res;
    }
}
