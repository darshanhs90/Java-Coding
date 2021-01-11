package Dec2020Leetcode;

public class _1550ThreeConsecutiveOdds {
	public static void main(String[] args) {
		System.out.println(threeConsecutiveOdds(new int[] { 2, 6, 4, 1 }));
		System.out.println(threeConsecutiveOdds(new int[] { 1, 2, 34, 3, 4, 5, 7, 23, 12 }));
		System.out.println(threeConsecutiveOdds(new int[] { 1, 3, 5 }));
	}

	public static boolean threeConsecutiveOdds(int[] arr) {
		for (int i = 0; i < arr.length - 2; i++) {
			int currVal = arr[i];
			if (currVal % 2 != 0)
				if (arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0)
					return true;
		}
		return false;
	}
}
