package google;
import java.util.*;

public class DoubleLinkedListConnectedComponent {
	public static class DoubleListNode{
		DoubleListNode pre;
		DoubleListNode next;
		int val;
		public DoubleListNode(int val){
			this.val = val;
		}
	}
	
	public static int numberOfConnectedComponent(Set<DoubleListNode> nodes){
		Set<DoubleListNode> temp = new HashSet<>(nodes);
		int cnt = 0;
		Iterator<DoubleListNode> it = nodes.iterator(); 
		while(it.hasNext()){
			DoubleListNode node = it.next();
			cnt++;
			temp.remove(node);
			DoubleListNode cur = node.next;
			while(cur != null && temp.contains(cur)){
				temp.remove(cur);
				cur = cur.next;
			}
			cur = node.pre;
			while(cur != null && temp.contains(cur)){
				temp.remove(cur);
				cur = cur.pre;
			}
			it = temp.iterator();
		}
		return cnt;
	}
	
	public static void main(String[] args){
		List<DoubleListNode> list = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			list.add(new DoubleListNode(i));
		}
		for(int i = 0; i < 10; i++){
			if(i != 0) list.get(i).pre = list.get(i - 1);
			if(i != 9) list.get(i).next = list.get(i + 1);
		}
		
		Set<DoubleListNode> set = new HashSet<>();
		for(int i = 0; i < 10; i += 1){
			set.add(list.get(i));
		}
		System.out.println(numberOfConnectedComponent(set));
	}
}
