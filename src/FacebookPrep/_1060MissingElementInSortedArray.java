package FacebookPrep;

public class _1060MissingElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(missingElement(new int[] { 4, 7, 9, 10 }, 1));
		System.out.println(missingElement(new int[] { 4, 7, 9, 10 }, 3));
		System.out.println(missingElement(new int[] { 1, 2, 4 }, 3));
	}

	public static int missingElement(int[] nums, int k) {
		long[] missingElements = new long[nums.length];
		missingElements[0] = 0;
		for (int i = 1; i < missingElements.length; i++) {
			missingElements[i] = missingElements[i - 1] + nums[i] - nums[i - 1] - 1;
		}
		long count = k;
		for (int i = 0; i < missingElements.length - 1; i++) {
			if (k >= missingElements[i] && k <= missingElements[i + 1]) {
				return (int) (nums[i] + count);
			}
			if (missingElements[i] != missingElements[i + 1])
				count -= missingElements[i + 1];
		}

		return (int) (nums[nums.length - 1] + count);
	}
}
