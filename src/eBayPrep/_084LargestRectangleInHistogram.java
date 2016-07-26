package eBayPrep1;

import java.util.Stack;

public class _084LargestRectangleInHistogram {

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
	}

	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack=new Stack<>();
		int i=0;
		int max=0;
		while (i < heights.length) {
			if(stack.isEmpty()||heights[i]>heights[stack.peek()])
			{
				stack.push(i);
				i++;
			}
			else{
				int index=stack.pop();
				int height=heights[index];
				int width=stack.isEmpty()?i:i-stack.peek()-1;
				max=Math.max(max, width*height);
			}
		}
		while (!stack.isEmpty()) {
			int index = stack.pop();
			int height = heights[index];
			int width = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(height * width, max);
		}
		return max;
	}
}

