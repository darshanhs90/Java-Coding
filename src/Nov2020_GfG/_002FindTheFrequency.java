package Nov2020_GfG;

public class _002FindTheFrequency {

	public static void main(String[] args) {
		System.out.println(findFrequency(new int[] { 1, 1, 1, 1, 1 }, 1));
	}

	static int findFrequency(int[] nums, int x) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == x)
				count++;
		}
		return count;
	}
}
