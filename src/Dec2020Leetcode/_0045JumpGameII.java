package Dec2020Leetcode;

public class _0045JumpGameII {

	public static void main(String[] args) {
		System.out.println(jump(new int[] { 3, 2, 1, 1, 4 }));
		System.out.println(jump(new int[] { 2, 3, 0, 1, 4 }));
	}

	public static int jump(int[] nums) {
		int min = 0, max = 0, count = 0;
		while (max < nums.length - 1) {
			int prevmax = max;
			while (min >= 0) {
				max = Math.max(max, min + nums[min]);
				min--;
			}
			if (prevmax == max)
				return -1;
			min = max;
			count++;
		}
		return count;
	}

}
