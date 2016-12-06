package fb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class FindKthClosestPointIn2DPlane {
	/*
	 * Heap, put all the points in the min heap
	 * and then poll k times to get the result;
	 * T: O(nlg(n)) S:O(n)
	 */
	public static Point findKthNearest(List<Point> points, Point target, int k){
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
			public int compare(Point p1, Point p2){
				double d1 = (p1.x - target.x) * (p1.x - target.x)
							+ (p1.y - target.y) * (p1.y - target.y);
				double d2 = (p2.x - target.x) * (p2.x - target.x)
							+ (p2.y - target.y) * (p2.y - target.y);
				return (int)(d1 - d2);
			}
		});
		
		for(Point point : points){
			pq.add(point);
		}
		
		for(int i = 0; i < k - 1; i++){
			pq.poll();
		}
		return pq.peek();
	}
	
	/*
	 * Heap, maintain a heap of size k, max heap
	 * T: O(nlg(k)), S:O(k)
	 */
	public static Point findKthNearest2(List<Point> points, Point target, int k){
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
			public int compare(Point p1, Point p2){
				double d1 = (p1.x - target.x) * (p1.x - target.x)
							+ (p1.y - target.y) * (p1.y - target.y);
				double d2 = (p2.x - target.x) * (p2.x - target.x)
							+ (p2.y - target.y) * (p2.y - target.y);
				return (int)(d2 - d1);
			}
		});
		
		for(Point point : points){
			pq.add(point);
			if(pq.size() > k) pq.poll();
		}
		return pq.peek();
	}
	
	public static Point findKthNearest3(Point[] points, Point target, int k){
		HashMap<Point, Double> map = new HashMap<Point, Double>();
		for(Point point : points){
			map.put(point, (point.x - target.x) * (point.x - target.x)
							+ (point.y - target.y) * (point.y - target.y));
		}
		int start = 0;
		int end = points.length - 1;
		while(start <= end){
			int pivot = partition(points, start, end, map);
			if(pivot == k - 1) return points[pivot];
			else if(pivot > k - 1){
				// should search in the left part
				end = pivot - 1;
			}else{
				start = pivot + 1;
			}
		}
		return null;
	}
	
	private static int partition(Point[] points, int start, int end, HashMap<Point, Double> map){
		double pivot = map.get(points[start]);
		int l = start + 1;
		int h = end;
		while(l <= h){
			while(l <= h && map.get(points[l]) <= pivot){
				l++;
			}
			while(h >= l && map.get(points[h]) >= pivot){
				h--;
			}
			if(l >= h) break;
			swap(points, l, h);
		}
		swap(points, start, h);
		return h;
	}
	
	private static void swap(Point[] points, int i, int j){
		Point point = points[i];
		points[i] = points[j];
		points[j] = point;
	}
	
	public static void main(String[] args){
		List<Point> points = new ArrayList<>();
		Point[] points1 = new Point[9];
		for(int i = 1; i < 10; i++){
			points.add(new Point(i,i));
			points1[i - 1] = new Point(i, i);
		}
		Point target = new Point(0,0);
		System.out.println(findKthNearest(points, target, 5));
		System.out.println(findKthNearest2(points, target, 5));
		System.out.println(findKthNearest3(points1, target, 5));
		
	}
	
	
}
