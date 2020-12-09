package Dec2020_HackerRankPrepKit;

public class _007MinimumSwaps2 {

	public static void main(String[] args) {
		System.out.println(minimumSwaps(new int[] { 4, 3, 1, 2 }));
		System.out.println(minimumSwaps(new int[] { 2, 3, 4, 1, 5 }));
		System.out.println(minimumSwaps(new int[] { 1, 3, 5, 2, 4, 6, 7 }));
		System.out.println(minimumSwaps(new int[] { 1, 2, 3, 4 }));
		System.out.println(minimumSwaps(new int[] { 1, 3, 2, 4 }));
	}

	static int minimumSwaps(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i + 1)
				continue;
			swap(arr, i, arr[i] - 1);
			i--;
			count++;
		}
		return count;
	}

	static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
