package Dec2020Leetcode;

public class _1037ValidBoomerang {

	public static void main(String[] args) {
		System.out.println(isBoomerang(new int[][] { new int[] { 1, 1 }, new int[] { 2, 3 }, new int[] { 3, 2 }, }));
		System.out.println(isBoomerang(new int[][] { new int[] { 1, 1 }, new int[] { 2, 2 }, new int[] { 3, 3 }, }));
	}

    public static boolean isBoomerang(int[][] p) {
        return (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) != (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
    }
}
