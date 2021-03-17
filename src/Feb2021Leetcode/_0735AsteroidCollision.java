package Feb2021Leetcode;

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
			if (stack.isEmpty()) {
				stack.push(asteroids[i]);
			} else {
				int num = asteroids[i];
				boolean addVal = false;
				if (!stack.isEmpty() && stack.peek() > 0 && num < 0) {
					while (!stack.isEmpty() && stack.peek() > 0 && num < 0) {
						int popVal = stack.pop();
						addVal = false;
						if (Math.abs(popVal) > Math.abs(num)) {
							stack.push(popVal);
							num = popVal;
						} else if (Math.abs(popVal) < Math.abs(num)) {
							// do nothing
							addVal = true;
						} else {
							break;
						}
					}

					if (addVal)
						stack.push(num);
				} else {
					stack.push(num);
				}
			}
		}

		int[] out = new int[stack.size()];
		for (int i = 0; i < out.length; i++) {
			out[out.length - 1 - i] = stack.pop();
		}
		return out;
	}
}
