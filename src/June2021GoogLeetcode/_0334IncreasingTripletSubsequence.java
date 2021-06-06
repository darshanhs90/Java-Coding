package June2021GoogLeetcode;

public class _0334IncreasingTripletSubsequence {

	public static void main(String[] args) {
		System.out.println(increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }));
	}

	public static boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3)
			return false;
		long num1 = Long.MAX_VALUE, num2 = Long.MAX_VALUE;
		for (int num : nums) {
			if (num <= num1) {
				num1 = num;
			} else if (num <= num2) {
				num2 = num;
			} else {
				return true;
			}
		}
		return false;
	}

}
