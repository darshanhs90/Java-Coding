package Jan2021Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class _0735AsteroidCollision {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(asteroidCollision(new int[] { 5, 10, -5 })));
		System.out.println(Arrays.toString(asteroidCollision(new int[] { 10, 2, -5 })));
		System.out.println(Arrays.toString(asteroidCollision(new int[] { 8, -8 })));
		System.out.println(Arrays.toString(asteroidCollision(new int[] { -2, -1, 1, 2 })));
		System.out.println(Arrays.toString(asteroidCollision(new int[] { -2, 2, 1, -2 })));
	}

	public static int[] asteroidCollision(int[] asteroids) {
		if (asteroids == null || asteroids.length < 2)
			return asteroids;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < asteroids.length; i++) {
			if (stack.isEmpty()) {
				stack.push(asteroids[i]);
			} else {
				int currVal = asteroids[i];
				if (stack.peek() > 0 && currVal < 0 && Math.abs(stack.peek()) == Math.abs(currVal)) {
					stack.pop();
					continue;
				}

				while (!stack.isEmpty() && stack.peek() > 0 && currVal < 0) {
					int val = stack.pop();
					if (Math.abs(val) == Math.abs(currVal)) {
						currVal = 0;
					} else {
						if (Math.abs(val) > Math.abs(currVal)) {
							currVal = val;
						}
					}
				}
				if (currVal != 0)
					stack.push(currVal);
			}
		}

		int[] out = new int[stack.size()];
		int index = out.length - 1;
		while (!stack.isEmpty()) {
			out[index] = stack.pop();
			index--;
		}
		return out;
	}
}
