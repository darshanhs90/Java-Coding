package Jan2021Leetcode;

public class _0540SingleElementInASortedArray {

	public static void main(String[] args) {
		System.out.println(singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
		System.out.println(singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
	}

	public static int singleNonDuplicate(int[] nums) {
		int val =nums[0];
		for (int i = 1; i < nums.length; i++) {
			val = val ^ nums[i];
		}
		return val;
	}
}
