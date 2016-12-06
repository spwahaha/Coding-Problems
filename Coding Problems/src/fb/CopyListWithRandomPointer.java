package fb;

import java.util.HashMap;

import leetcode.RandomListNode;

public class CopyListWithRandomPointer {
	//https://leetcode.com/problems/copy-list-with-random-pointer/
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while(node != null){
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        
        node = head;
        while(node != null){
            RandomListNode copied = map.get(node);
            copied.next = map.get(node.next);
            copied.random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
    
    
}
