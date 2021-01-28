package LeetcodeTemplate;

public class _1351CountNegativeNumbersInASortedMatrix {
	public static void main(String[] args) {
		System.out.println(countNegatives(new int[][] { new int[] { 4, 3, 2, -1 }, new int[] { 3, 2, 1, -1 },
				new int[] { 1, 1, -1, -2 }, new int[] { -1, -1, -2, -3 } }));

		System.out.println(countNegatives(new int[][] { new int[] { 3, 2 }, new int[] { 1, 0 } }));
		System.out.println(countNegatives(new int[][] { new int[] { 1, -1 }, new int[] { -1, -1 } }));
		System.out.println(countNegatives(new int[][] { new int[] { -1 } }));

		System.out.println(countNegatives(new int[][] { new int[] { 4, 3, 3, 1, 1 }, new int[] { 1, 0, 0, -1, -1 },
				new int[] { -2, -2, -2, -2, -3 }, new int[] { -2, -2, -2, -3, -3 },
				new int[] { -3, -3, -3, -3, -3 } }));
	}

	public static int countNegatives(int[][] grid) {
		
	}

}
