package Feb2021Leetcode;

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
		int[] out = new int[n];
		if (logs == null || logs.size() == 0)
			return out;

		String str[] = logs.get(0).split(":");
		Stack<Integer> stack = new Stack<Integer>();
		int prevIndex = Integer.parseInt(str[0]);
		int prevTime = Integer.parseInt(str[2]);
		stack.push(prevIndex);

		for (int i = 1; i < logs.size(); i++) {
			str = logs.get(i).split(":");
			int currIndex = Integer.parseInt(str[0]);
			int currTime = Integer.parseInt(str[2]);
			if (str[1].equals("start")) {
				if (!stack.isEmpty()) {
					out[stack.peek()] += currTime - prevTime;
				}
				prevTime = currTime;
				stack.push(currIndex);
			} else {
				out[stack.pop()] += currTime - prevTime + 1;
				prevTime = currTime + 1;
			}
		}
		return out;
	}

}
