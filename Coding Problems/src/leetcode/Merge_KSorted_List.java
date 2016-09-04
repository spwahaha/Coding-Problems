package leetcode;

import java.util.PriorityQueue;
import java.util.Comparator;

public class Merge_KSorted_List {
	//https://leetcode.com/problems/merge-k-sorted-lists/
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }
    
    private ListNode merge(ListNode[] lists, int start, int end){
        if(start > end) return null;
        if(start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode node1 = merge(lists, start, mid);
        ListNode node2 = merge(lists, mid + 1, end);
        return mergeTwoList(node1, node2);
    }
    
    private ListNode mergeTwoList(ListNode node1, ListNode node2){
        if(node1 == null && node2 == null) return null;
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while(node1 != null && node2 != null){
            if(node1.val < node2.val){
                node.next = node1;
                node1 = node1.next;
            }else{
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        if(node1 == null) node.next = node2;
        if(node2 == null) node.next = node1;
        return dummy.next;
    }
    
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) pq.add(lists[i]);
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            node.next = min;
            if(min.next != null) pq.add(min.next);
            node = node.next;
        }
        return dummy.next;
    }
}
