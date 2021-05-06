package May2021PrepLeetcode;

public class _0169MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
	}

	public static int majorityElement(int[] nums) {
		Integer candidate = null;
		int count = 0;
		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += num == candidate ? 1 : -1;
		}

		return candidate;
	}

}
