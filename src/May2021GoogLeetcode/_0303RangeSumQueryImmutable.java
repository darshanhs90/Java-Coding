package May2021GoogLeetcode;

public class _0303RangeSumQueryImmutable {

	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
	}

	static class NumArray {
		int[] sum;

		public NumArray(int[] nums) {
			sum = new int[nums.length + 1];
			sum[0] = 0;
			for (int i = 0; i < nums.length; i++) {
				sum[i + 1] = sum[i] + nums[i];
			}
		}

		public int sumRange(int left, int right) {
			return sum[right + 1] - sum[left];
		}
	}

}
