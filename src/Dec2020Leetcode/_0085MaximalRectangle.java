package Dec2020Leetcode;

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

		int[] dp = new int[matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			dp[i] = matrix[0][i] == '1' ? 1 : 0;
		}
		int maxArea = findMaxAreaOfHistogram(dp);
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
			}
			maxArea = Math.max(maxArea, findMaxAreaOfHistogram(dp));
		}
		return maxArea;
	}

	public static int findMaxAreaOfHistogram(int[] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i;
		for (i = 0; i < matrix.length; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
			} else if (matrix[stack.peek()] <= matrix[i]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && matrix[stack.peek()] >= matrix[i]) {
					int top = stack.pop();
					if (stack.isEmpty()) {
						maxArea = Math.max(maxArea, matrix[top] * i);
					} else {
						maxArea = Math.max(maxArea, matrix[top] * (i - stack.peek() - 1));
					}
				}
				stack.push(i);
			}
		}

		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (stack.isEmpty()) {
				maxArea = Math.max(maxArea, matrix[top] * i);
			} else {
				maxArea = Math.max(maxArea, matrix[top] * (i - stack.peek() - 1));
			}
		}

		return maxArea;
	}

}
