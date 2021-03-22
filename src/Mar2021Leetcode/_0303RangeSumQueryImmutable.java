package Mar2021Leetcode;

public class _0303RangeSumQueryImmutable {

	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
	}

	static class NumArray {
		public NumArray(int[] nums) {
		}

		public int sumRange(int i, int j) {
		}
	}

}
