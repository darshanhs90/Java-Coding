package May2021GoogLeetcode;

import java.util.Stack;

public class _0946ValdateStackSequences {

	public static void main(String[] args) {
		System.out.println(validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 }));
		System.out.println(validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 3, 5, 1, 2 }));
		System.out.println(validateStackSequences(new int[] { 2, 1, 0 }, new int[] { 1, 2, 0 }));
	}

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		int index1 = 0, index2 = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (index1 < pushed.length || index2 < popped.length) {
			if (index1 < pushed.length) {

				if (!stack.isEmpty() && stack.peek() == popped[index2]) {
					stack.pop();
					index2++;
					continue;
				}

				stack.push(pushed[index1]);

				if (pushed[index1] == popped[index2]) {
					stack.pop();
					index2++;
				}
				index1++;
			} else {
				if (stack.isEmpty())
					return false;
				if (stack.peek() != popped[index2])
					return false;
				stack.pop();
				index2++;
			}
		}
		return stack.isEmpty();
	}
}
