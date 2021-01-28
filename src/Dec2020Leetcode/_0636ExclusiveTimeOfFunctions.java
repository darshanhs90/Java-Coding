package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _0636ExclusiveTimeOfFunctions {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(exclusiveTime(2,
				new ArrayList<String>(Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6")))));

		System.out.println(Arrays.toString(exclusiveTime(1, new ArrayList<String>(
				Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7")))));

		System.out.println(Arrays.toString(exclusiveTime(2, new ArrayList<String>(
				Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7")))));

		System.out.println(Arrays.toString(exclusiveTime(2, new ArrayList<String>(
				Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8")))));

		System.out.println(
				Arrays.toString(exclusiveTime(1, new ArrayList<String>(Arrays.asList("0:start:0", "0:end:0")))));
	}

	public static int[] exclusiveTime(int n, List<String> logs) {
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[n];
		String[] s = logs.get(0).split(":");
		stack.push(Integer.parseInt(s[0]));
		int i = 1, prev = Integer.parseInt(s[2]);
		while (i < logs.size()) {
			s = logs.get(i).split(":");
			if (s[1].equals("start")) {
				if (!stack.isEmpty())
					res[stack.peek()] += Integer.parseInt(s[2]) - prev;
				stack.push(Integer.parseInt(s[0]));
				prev = Integer.parseInt(s[2]);
			} else {
				res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
				stack.pop();
				prev = Integer.parseInt(s[2]) + 1;
			}
			i++;
		}
		return res;
	}

}
