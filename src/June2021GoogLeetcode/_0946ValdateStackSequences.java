package June2021GoogLeetcode;

import java.util.Stack;

public class _0946ValdateStackSequences {

	public static void main(String[] args) {
		System.out.println(validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 }));
		System.out.println(validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 3, 5, 1, 2 }));
		System.out.println(validateStackSequences(new int[] { 2, 1, 0 }, new int[] { 1, 2, 0 }));
	}

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		if (pushed.length != popped.length)
			return false;
		Stack<Integer> stack = new Stack<Integer>();
		int index1 = 0, index2 = 0;
		while (index1 < pushed.length && index2 < popped.length) {

			if (!stack.isEmpty() && stack.peek() == popped[index2]) {
				stack.pop();
				index2++;
				continue;
			}

			stack.push(pushed[index1]);
			index1++;
		}

		while (!stack.isEmpty() && index2 < popped.length) {
			if (stack.peek() == popped[index2]) {
				stack.pop();
				index2++;
			} else {
				return false;
			}
		}

		return true;
	}
}
