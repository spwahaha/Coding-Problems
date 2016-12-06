package sort;

import leetcode.Utilis;

public class QuickSort {
	public static void sort(int[] nums){
		int start = 0;
		int end = nums.length - 1;
		sort(nums, start, end);
	}
	
	private static void sort(int[] nums, int start, int end){
		if(start >= end) return;
		int pivot = partition(nums, start, end);
		sort(nums, start, pivot - 1);
		sort(nums, pivot + 1, end);
	}
	
	private static int partition(int[] nums, int start, int end){
		int pivot = nums[start];
		int l = start + 1;
		int h = end;
		while(l <= h){
			while(l < end && nums[l] <= pivot){
				l++;
			}
			while(h > start && nums[h] >= pivot){
				h--;
			}
			if(l >= h) break;
			swap(nums, l, h);
		}
		swap(nums, start, h);
		return h;
	}
	
	private static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args){
		int[] nums = {3,2,1,5,6,4};
		sort(nums);
		Utilis.printArray(nums);;
	}
}
