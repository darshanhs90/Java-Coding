package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _018ExclusiveTimeOfFunctions {

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
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		String[] newStr = logs.get(0).split(":");
		stack.push(Integer.parseInt(newStr[0]));
		int prevEnd = Integer.parseInt(newStr[2]);
		for (int i = 1; i < logs.size(); i++) {
			String str = logs.get(i);
			String[] strArray = str.split(":");
			if (strArray[1].equals("start")) {
				if (stack.isEmpty()) {
					stack.push(Integer.parseInt(strArray[0]));
					prevEnd = Integer.parseInt(strArray[2]);
				} else {
					res[stack.peek()] += Integer.parseInt(strArray[2]) - prevEnd;
					stack.push(Integer.parseInt(strArray[0]));
					prevEnd = Integer.parseInt(strArray[2]);
				}
			} else {
				res[stack.peek()] += Integer.parseInt(strArray[2]) - prevEnd + 1;
				stack.pop();
				prevEnd = Integer.parseInt(strArray[2])+1;
			}
		}
		return res;
	}
}
