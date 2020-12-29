package Dec2020Leetcode;

import java.util.Stack;

public class _0084LargestRectangleInHistogram {

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
	}

	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		int i;
		for (i = 0; i < heights.length; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
			} else if (heights[stack.peek()] <= heights[i]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
					int pop = stack.pop();
					if (stack.isEmpty()) {
						maxArea = Math.max(maxArea, heights[pop] * (i));
					} else {
						maxArea = Math.max(maxArea, heights[pop] * (i - stack.peek() - 1));
					}
				}
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			int pop = stack.pop();
			if (stack.isEmpty()) {
				maxArea = Math.max(maxArea, heights[pop] * (i));
			} else {
				maxArea = Math.max(maxArea, heights[pop] * (i - stack.peek() - 1));
			}
		}

		return maxArea;
	}
}
