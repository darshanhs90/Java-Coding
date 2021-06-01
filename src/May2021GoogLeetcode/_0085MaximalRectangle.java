package May2021GoogLeetcode;

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
		int[] heights = new int[matrix[0].length];
		int maxArea = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == '0') {
					heights[j] = 0;
				} else {
					heights[j] = heights[j] + 1;
				}
			}
			maxArea = Math.max(maxArea, largestRectangleArea(heights));
		}
		return maxArea;
	}

	public static int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		int i = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		for (i = 0; i < heights.length; i++) {

			while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {

				int height = heights[stack.pop()];
				int width = i - stack.peek() - 1;
				maxArea = Math.max(maxArea, height * width);
			}
			// push index
			stack.push(i);
		}

		while (!stack.isEmpty() && stack.peek() != -1) {
			int height = heights[stack.pop()];
			int width = i - stack.peek() - 1;
			maxArea = Math.max(maxArea, height * width);
		}
		return maxArea;
	}

}
