package google;

public class RangeSumQueryMutable {

    int[] tree;
    int[] array;
    public RangeSumQueryMutable(int[] nums) {
        int n = nums.length;
        this.tree = new int[n + 1];
        array = new int[n];
        for(int i = 0; i < nums.length; i++){
            update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int delta = val - array[i];
        array[i] = val;
        for(int j = i + 1; j < tree.length; j += (j & (-j))){
            this.tree[j] += delta;
        }
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }
    
    private int sum(int i){
        int sum = 0;
        for(int j = i; j > 0; j -= (j & (-j))){
            sum += this.tree[j];
        }
        return sum;
    }
    
    public static void main(String[] args){
    	int[] nums = {1,3,5};
    	RangeSumQueryMutable rs = new RangeSumQueryMutable(nums);
    	System.out.println(rs.sumRange(0, 2));
    	
    }
    
}
