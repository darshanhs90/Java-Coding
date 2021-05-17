package May2021Leetcode;

public class _0477TotalHammingDistance {

	public static void main(String[] args) {
		System.out.println(totalHammingDistance(new int[] { 4, 14, 2 }));
		System.out.println(totalHammingDistance(new int[] { 4, 14, 4 }));
	}

	public static int totalHammingDistance(int[] nums) {
		int total = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int num : nums) {
				count += (num >> i) & 1;
			}
			total += (count * (nums.length - count));
		}
		return total;
	}
}
