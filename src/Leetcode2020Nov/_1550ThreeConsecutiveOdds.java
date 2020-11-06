package Leetcode2020Nov;

public class _1550ThreeConsecutiveOdds {
	public static void main(String[] args) {
		System.out.println(threeConsecutiveOdds(new int[] { 2, 6, 4, 1 }));
		System.out.println(threeConsecutiveOdds(new int[] { 1, 2, 34, 3, 4, 5, 7, 23, 12 }));
	}

	public static boolean threeConsecutiveOdds(int[] arr) {
		int oddCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1) {
				oddCount++;
				if (oddCount == 3)
					return true;
			} else {
				oddCount = 0;
			}
		}
		return false;
	}
}
