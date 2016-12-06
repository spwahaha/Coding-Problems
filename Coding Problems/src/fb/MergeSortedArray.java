package fb;

import leetcode.Utilis;

public class MergeSortedArray {
	//https://leetcode.com/problems/merge-sorted-array/
    /*
     * in place merge,
     */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[len--] = nums1[p1--];
            }else{
                nums1[len--] = nums2[p2--];
            }
        }
        while(p2 >= 0){
            nums1[len--] = nums2[p2--];
        }
    }
	
	public static int[] merge(int[] array1, int[] array2){
		if(array1 == null || array1.length == 0) return array2;
		if(array2 == null || array2.length == 0) return array1;
		int p1 = array1.length - 1;
		int p2 = array2.length - 1;
		int[] res = new int[p1 + p1 + 2];
		for(int p = res.length - 1; p >= 0; p--){
			if(p1 < 0){
				res[p] = array2[p2--];
			}else if(p2 < 0){
				res[p] = array1[p1--];
			}else{
				res[p] = array1[p1] > array2[p2] ? array1[p1--] : array2[p2--];
			}
		}
		return res;
	}
	
    public static void main(String[] arg) {
        Utilis.printArray((merge(new int[]{1, 2, 5, 7}, new int[]{3, 5, 6, 10})));
    }
}
