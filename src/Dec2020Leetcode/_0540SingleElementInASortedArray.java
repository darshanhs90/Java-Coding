package Dec2020Leetcode;

public class _0540SingleElementInASortedArray {

	public static void main(String[] args) {
		System.out.println(singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
		System.out.println(singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
	}

	public static int singleNonDuplicate(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int right = 0;
		while (right < nums.length) {
			int count = 1;
			int index = right + 1;
			while (index < nums.length && nums[index] == nums[right]) {
				index++;
				count++;
			}
			if (count == 1)
				return nums[right];
			else {
				right = index;
			}
		}
		return -1;
	}
}
