package May2021PrepLeetcode;

public class _0477TotalHammingDistance {

	public static void main(String[] args) {
		System.out.println(totalHammingDistance(new int[] { 4, 14, 2 }));
		System.out.println(totalHammingDistance(new int[] { 4, 14, 4 }));
	}

	public static int totalHammingDistance(int[] nums) {
		int count = 0;
		for (int i = 0; i < 31; i++) {
			int noOfOnes = 0;
			for (int num : nums) {
				noOfOnes += num >> i & 1;
			}
			count += noOfOnes * (nums.length - noOfOnes);
		}
		return count;
	}
}
