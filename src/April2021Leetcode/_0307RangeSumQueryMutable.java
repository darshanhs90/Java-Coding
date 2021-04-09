package April2021Leetcode;

public class _0307RangeSumQueryMutable {
	// https://www.youtube.com/watch?v=GURRzAKL1lY
	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] { 1, 3, 5 });
		System.out.println(numArray.sumRange(0, 2));// -> 9
		numArray.update(1, 2);
		System.out.println(numArray.sumRange(0, 2));// -> 8
	}

	static class NumArray {
		
		public NumArray(int[] nums) {
		}

		public int sumRange(int i, int j) {
		}

	}

}
