package leetcode;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
	
	public String toString(){
		if(next == null) return this.val + "";
		else return this.val + "->" + next.toString();
	}
}
