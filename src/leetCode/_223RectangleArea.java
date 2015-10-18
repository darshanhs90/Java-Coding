package leetCode;

/*
 * Link : https://leetcode.com/problems/rectangle-area/
 */

public class _223RectangleArea {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

		int rectangle1Area=Math.abs(A-C)*Math.abs(B-D);
		int rectangle2Area=Math.abs(E-G)*Math.abs(F-H);
		System.out.println(rectangle1Area);
		System.out.println(rectangle2Area	);


		return 0;
	}

	public static void main(String[] args) {
		computeArea(-3, 0,3, 4, 0, -1, 9, 2);
	}
}