package LeetcodeTemplate;

public class _0074SearchA2DMatrix {

	public static void main(String[] args) {
		System.out.println(searchMatrix(
				new int[][] { new int[] { 1, 3, 5, 7 }, new int[] { 10, 11, 16, 20 }, new int[] { 23, 30, 34, 50 } },
				3));
		System.out.println(searchMatrix(
				new int[][] { new int[] { 1, 3, 5, 7 }, new int[] { 10, 11, 16, 20 }, new int[] { 23, 30, 34, 50 } },
				13));
		System.out.println(searchMatrix(new int[][] {}, 0));
	}

	

}
