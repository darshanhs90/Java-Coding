package Mar2021Leetcode;

public class _0334IncreasingTripletSubsequence {

	public static void main(String[] args) {
		System.out.println(increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }));

	}

	public static boolean increasingTriplet(int[] nums) {
		int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= num1) {
				num1 = nums[i];
			} else if (nums[i] <= num2) {
				num2 = nums[i];
			} else {
				return true;
			}
		}
		return false;
	}

}
