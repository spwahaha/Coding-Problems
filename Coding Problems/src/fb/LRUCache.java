package fb;

import java.util.HashMap;

public class LRUCache {
	//https://leetcode.com/problems/lru-cache/
    class ListNode{
        int key;
        int val;
        ListNode pre;
        ListNode next;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer, ListNode> map = new HashMap<>();
    int capacity;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        ListNode node = map.get(key);
        if(node == null) return -1;
        remove(node);
        addToTail(node);
        return node.val;
    }
    
    public void addToTail(ListNode node){
        ListNode beforeTail = tail.pre;
        beforeTail.next = node;
        node.next = tail;
        tail.pre = node;
        node.pre = beforeTail;
    }
    
    public void remove(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    } 
    
    
    public void set(int key, int value) {
        int val = get(key);
        if(val != -1){
            map.get(key).val = value;
            return;
        }
        ListNode inserted = new ListNode(key, value);
        if(map.size() == capacity){
            // remove the first one
        	map.remove(head.next.key);
            remove(head.next);
        }
        map.put(key,  inserted);
        addToTail(inserted);
    }
    
    public static void main(String[] args){
    	LRUCache lru = new LRUCache(1);
    	lru.set(2, 1);
    	System.out.println(lru.get(2));    	
    	lru.set(3, 2);
    	System.out.println(lru.get(2));    	
    	System.out.println(lru.get(3));    	
    }
}
