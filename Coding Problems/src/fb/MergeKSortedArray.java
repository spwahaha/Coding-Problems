package fb;

import java.util.Comparator;
import java.util.PriorityQueue;

import leetcode.Utilis;

public class MergeKSortedArray {
    
	/*
	 * similar to merge sort, 
	 * T:O(n * log(K))
	 */
	public static int[] mergeKArrays(int[][] arrays) {
    	if(arrays == null || arrays.length == 0) return null;
    	return merge(arrays, 0, arrays.length - 1);
    }
	
	private static int[] merge(int[][] arrays, int start, int end){
		if(start == end) return arrays[start];
		if(start > end) return new int[0];
		int mid = start + (end - start) / 2;
		int[] a1 = merge(arrays, start, mid);
		int[] a2 = merge(arrays, mid + 1, end);
		return merge(a1, a2);
	}
	
	private static int[] merge(int[] a1, int[] a2){
		int[] res = new int[a1.length + a2.length];
		int i1 = 0;
		int i2 = 0;
		for(int i = 0; i < res.length; i++){
			if(i1 == a1.length){
				res[i] = a2[i2++];
			}else if(i2 == a2.length){
				res[i] = a1[i1++];
			}else{
				res[i] = a1[i1] < a2[i2] ? a1[i1++] : a2[i2++];
			}
		}
		return res;
	}
	
	public static int[] mergeKArrays2(int[][] arrays) {
		if(arrays == null || arrays.length == 0) return new int[0];
		PriorityQueue<ArrayWrapper> pq = new PriorityQueue(new Comparator<ArrayWrapper>(){
			public int compare(ArrayWrapper w1, ArrayWrapper w2){
				return w1.array[w1.p] - w2.array[w2.p];
			}
		});
		int len = 0;
		for(int[] array : arrays){
			len += array.length;
			pq.add(new ArrayWrapper(array));
		}
		int[] res = new int[len];
		int index = 0; 
		while(!pq.isEmpty()){
			ArrayWrapper aw = pq.poll();
			res[index++] = aw.array[aw.p++];
			if(aw.p < aw.array.length){
				pq.add(aw);
			}
		}
		return res;
	}

	static class ArrayWrapper{
		int p;
		int[] array;
		ArrayWrapper(int[] array){
			this.array = array;
			this.p = 0;
		}
	}
	
	
    public static void main(String[] arg) {
        Utilis.printArray(mergeKArrays(new int[][]{
                {1, 2, 3}, {2, 5, 7}, {0, 5, 9}, {8, 9, 10}
        }));
        Utilis.printArray(mergeKArrays2(new int[][]{
            {1, 2, 3}, {2, 5, 7}, {0, 5, 9}, {8, 9, 10}
        }));
    }
    

}
