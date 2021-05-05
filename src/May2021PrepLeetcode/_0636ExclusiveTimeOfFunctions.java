package May2021PrepLeetcode;

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
		String str = logs.get(0);
		String[] strArr = str.split(":");
		int prevTime = Integer.parseInt(strArr[2]);
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(Integer.parseInt(strArr[0]));

		for (int i = 1; i < logs.size(); i++) {
			str = logs.get(i);
			strArr = str.split(":");
			int currIndex = Integer.parseInt(strArr[0]);
			int currTime = Integer.parseInt(strArr[2]);
			if (strArr[1].equals("start")) {
				if (!stack.isEmpty()) {
					out[stack.peek()] += currTime - prevTime;
				}
				stack.push(currIndex);
				prevTime = currTime;
			} else {
				out[stack.pop()] += currTime - prevTime + 1;
				prevTime = currTime + 1;
			}
		}
		return out;
	}

}
