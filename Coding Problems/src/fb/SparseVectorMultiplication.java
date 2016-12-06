package fb;

public class SparseVectorMultiplication {

	public static int sparseVectorMultiplication(int[] nums1, int[] nums2){
		int res = 0;
		for(int i = 0; i < nums1.length; i++){
			res += nums1[i] * nums2[i];
		}
		return res;
	}
	
    public static void main(String[] arg) {
        System.out.println(sparseVectorMultiplication(new int[]{1, 0, 0, 0, 2, 3, 0}, new int[]{2, 3, 0, 1, 0, 1, 2}));
    }
}
