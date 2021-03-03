package FacebookPrep;

public class _1570DotProductOfTwoSparseVectors {
	public static void main(String[] args) {
		SparseVector v1 = new SparseVector(new int[] { 1, 0, 0, 2, 3 });
		SparseVector v2 = new SparseVector(new int[] { 0, 3, 0, 4, 0 });
		System.out.println(v1.dotProduct(v2));
	}

	static class SparseVector {
		public int[] nums;

		SparseVector(int[] nums) {
			this.nums = nums;
		}

		// Return the dotProduct of two sparse vectors
		public int dotProduct(SparseVector vec) {
			int[] newArr = vec.nums;
			int val = 0;
			for (int i = 0; i < newArr.length; i++) {
				val += newArr[i] * this.nums[i];
			}
			return val;
		}
	}
}
