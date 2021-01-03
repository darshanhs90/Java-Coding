package Dec2020Leetcode;

public class _0303RangeSumQueryImmutable {

	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
	}

	static class NumArray {
		int[] sumArray;

		public NumArray(int[] nums) {
			sumArray = new int[nums.length + 1];
			sumArray[0] = 0;
			for (int i = 1; i < sumArray.length; i++) {
				sumArray[i] = sumArray[i - 1] + nums[i - 1];
			}
		}

		public int sumRange(int i, int j) {
			return sumArray[j + 1] - sumArray[i];
		}
	}

}
