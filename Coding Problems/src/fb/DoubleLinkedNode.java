package fb;


public class DoubleLinkedNode {
	int val;
	DoubleLinkedNode pre;
	DoubleLinkedNode next;
	DoubleLinkedNode(int val){
		this.val = val;
	}
	
	public String toString(){
		DoubleLinkedNode root = this;
		String res = root.val + "";
		while(root.next != null){
			res += "->" + root.next.val;
			root = root.next;
		}
		res += "\n";
		res += root.val;
		while(root.pre != null){
			res += "->" + root.pre.val;
			root = root.pre;
		}
		return res;
	}
}
