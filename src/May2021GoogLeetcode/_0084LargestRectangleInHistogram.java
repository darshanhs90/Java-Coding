package May2021GoogLeetcode;

import java.util.Stack;

public class _0084LargestRectangleInHistogram {

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
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
