package FacebookPortalPrep;

public class _0024Graphs_MinimizingPermutations {

	public static void main(String[] args) {
		System.out.println(minOperations(new int[] { 3, 1, 2 }));
		System.out.println(minOperations(new int[] { 1, 2, 4, 3 }));
	}

	public static int minOperations(int[] arr) {
		// Write your code here
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				int index = findIndexOf(i, i + 1, arr);
				reverseArr(arr, i, index);
				count++;
			}
		}
		return count;
	}

	public static int findIndexOf(int index, int number, int[] arr) {
		for (int i = index; i < arr.length; i++) {
			if (arr[i] == number)
				return i;
		}
		return -1;
	}

	public static void reverseArr(int[] arr, int left, int right) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}
