package May2021GoogLeetcode;

public class _0334IncreasingTripletSubsequence {

	public static void main(String[] args) {
		System.out.println(increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }));
	}

	public static boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3)
			return false;
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= first) {
				first = nums[i];
			} else if (nums[i] <= second) {
				second = nums[i];
			} else {
				return true;
			}
		}
		return false;
	}

}
