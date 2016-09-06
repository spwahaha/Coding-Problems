package leetcode;

public class Utilis {
	public static void printArray(int[] nums){
		for(int num : nums) System.out.print(num + " ");
	}
	
	public static void printArray(int[][] nums){
		for(int[] num : nums){
			for(int n : num) System.out.print(n + " ");
			System.out.println();
		}
	}
	
	public static void printArray(char[][] nums){
		for(char[] num : nums){
			for(char n : num) System.out.print(n + " ");
			System.out.println();
		}
	}
	
	public static ListNode generateListNode(int[] nums){
    	ListNode head = new ListNode(nums[0]);
    	ListNode node = head;
    	for(int i = 1; i < nums.length; i++){
    		node.next = new ListNode(nums[i]);
    		node = node.next;
    	}
    	return head;
	}
}
