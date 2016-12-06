package fb;

public class IntersectionOfTwoSortedArrays {
	public static int intersection(int[] nums1, int[] nums2){
		int p1 = 0;
		int p2 = 0;
		while(p1 < nums1.length && p2 < nums2.length){
			if(nums1[p1] == nums2[p2]) return nums1[p1];
			else if(nums1[p1] < nums2[p2]){
				p1++;
			}else{
				p2++;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] nums1 = {1,3,4,5,7,9};
		int[] nums2 = {0, 6, 7};
		System.out.println(intersection(nums1, nums2));
	}
}
