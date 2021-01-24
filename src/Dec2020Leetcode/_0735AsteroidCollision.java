package Dec2020Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class _0735AsteroidCollision {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(asteroidCollision(new int[] { 5, 10, -5 })));
		System.out.println(Arrays.toString(asteroidCollision(new int[] { 10, 2, -5 })));
		System.out.println(Arrays.toString(asteroidCollision(new int[] { 8, -8 })));
		System.out.println(Arrays.toString(asteroidCollision(new int[] { -2, -1, 1, 2 })));
	}

	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < asteroids.length; i++) {
			Integer val = asteroids[i];
			if (stack.isEmpty()) {
				stack.push(val);
			} else {
				if (stack.peek() > 0 && val < 0) {
					while (!stack.isEmpty() && stack.peek() > 0 && val != null && val < 0) {
						int prevVal = stack.pop();
						if (Math.abs(prevVal) == Math.abs(val)) {
							// do nothing
							val = null;
						} else {
							if (Math.abs(prevVal) > Math.abs(val))
								stack.push(prevVal);
							else
								stack.push(val);
						}
						if (val != null)
							val = stack.pop();
					}
					if (val != null)
						stack.push(val);
				} else {
					stack.push(val);
				}
			}
		}

		int[] output = new int[stack.size()];
		for (int i = 0; i < output.length; i++) {
			output[output.length - i - 1] = stack.pop();
		}
		return output;
	}
}
