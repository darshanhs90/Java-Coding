package June2021GoogLeetcode;

import java.util.Stack;

public class _0085MaximalRectangle {

	public static void main(String[] args) {
		System.out.println(maximalRectangle(
				new char[][] { new char[] { '1', '0', '1', '0', '0' }, new char[] { '1', '0', '1', '1', '1' },
						new char[] { '1', '1', '1', '1', '1' }, new char[] { '1', '0', '0', '1', '0' }, }));

		System.out.println(maximalRectangle(new char[][] {}));

		System.out.println(maximalRectangle(new char[][] { new char[] { '0' } }));

		System.out.println(maximalRectangle(new char[][] { new char[] { '1' } }));

		System.out.println(maximalRectangle(new char[][] { new char[] { '0', '0' } }));

		System.out.println(maximalRectangle(new char[][] { new char[] { '0', '1' } }));
	}

	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int[] mat = new int[matrix[0].length];

		for (int i = 0; i < mat.length; i++) {
			if (matrix[0][i] == '1') {
				mat[i] = 1;
			}
		}

		int max = largestRectangleArea(mat);
		for (int i = 1; i < matrix.length; i++) {

			for (int j = 0; j < mat.length; j++) {
				if (matrix[i][j] == '0') {
					mat[j] = 0;
				} else {
					mat[j] += 1;
				}
			}
			max = Math.max(max, largestRectangleArea(mat));
		}
		return max;
	}

	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int max = 0;
		int i = 0;
		for (i = 0; i < heights.length; i++) {

			while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
				int height = heights[stack.pop()];
				int width = i - stack.peek() - 1;
				max = Math.max(max, height * width);
			}
			stack.push(i);
		}

		while (stack.peek() != -1) {
			int height = heights[stack.pop()];
			int width = i - stack.peek() - 1;
			max = Math.max(max, height * width);
		}
		return max;
	}

}
