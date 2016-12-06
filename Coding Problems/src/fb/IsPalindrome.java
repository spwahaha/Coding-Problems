package fb;
import java.util.*;
import leetcode.ListNode;
import leetcode.Utilis;

public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            list.add(node.val);
            node = node.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while(i < j){
            if(!list.get(i++).equals(list.get(j--))) return false;
        }
        return true;
    }
    
    public static void main(String[] args){
    	ListNode head = Utilis.generateListNode(new int[]{1,2,3,4,5,4,3,2,1});
    	System.out.println(isPalindrome(head));
    	
    }
}
