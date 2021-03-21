package Feb2021Leetcode;

import java.util.Stack;

public class _0084LargestRectangleInHistogram {

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
	}

	public static int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
				int currHeight = heights[stack.pop()];
				int distance = i - stack.peek() - 1;
				maxArea = Math.max(maxArea, distance * currHeight);
			}
			stack.push(i);
		}

		while (!stack.isEmpty() && stack.peek() != -1) {
			int currHeight = heights[stack.pop()];
			int distance = heights.length - stack.peek() - 1;
			maxArea = Math.max(maxArea, distance * currHeight);
		}
		return maxArea;
	}
}
