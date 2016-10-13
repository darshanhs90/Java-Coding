package PracticeLeetCode;

public class _303RangeSumQuery {
	public static void main(String[] args) {
		_303RangeSumQuery a=new _303RangeSumQuery(new int[]{-2, 0, 3, -5, 2, -1});
		System.out.println(a.sumRange(0, 2));
		System.out.println(a.sumRange(2, 5));
		System.out.println(a.sumRange(0, 5));		
	}
	int sum[];
	public _303RangeSumQuery(int[] nums) {
		sum=new int[nums.length];
		if(nums.length==0)
			return;
		sum[0]=nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum[i]+=sum[i-1]+nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return i==0?sum[j]:sum[j]-sum[i-1];
	}
}
