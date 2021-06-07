package June2021GoogLeetcode;

public class _0169MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
	}

	public static int majorityElement(int[] nums) {
		int count = 0;
		int major = 0;
		for (int num : nums) {
			if (count == 0) {
				major = num;
			}
			if (major == num) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}

}
