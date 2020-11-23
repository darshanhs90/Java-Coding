package Nov2020Leetcode;

public class _0303RangeSumQueryImmutable {

	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
	}

	static class NumArray {
		int[] rangeSum;

		public NumArray(int[] nums) {
			rangeSum = new int[nums.length + 1];
			rangeSum[0] = 0;
			for (int i = 0; i < nums.length; i++) {
				rangeSum[i + 1] = nums[i] + rangeSum[i];
			}
		}

		public int sumRange(int i, int j) {
			return rangeSum[j + 1] - rangeSum[i];
		}
	}
}
