package Mar2021Leetcode;

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

		Stack<Integer> stack = new Stack<Integer>();
		int prev = 0;
		String strArr[] = logs.get(0).split(":");
		prev = Integer.parseInt(strArr[2]);
		stack.push(Integer.parseInt(strArr[0]));

		for (int i = 1; i < logs.size(); i++) {
			strArr = logs.get(i).split(":");
			int curr = Integer.parseInt(strArr[2]);
			if (strArr[1].equals("start")) {

				if (!stack.isEmpty())
					out[stack.peek()] += curr - prev;

				stack.push(Integer.parseInt(strArr[0]));
				prev = curr;
			} else {
				out[stack.pop()] += curr - prev + 1;
				prev = curr + 1;
			}
		}
		return out;
	}

}
