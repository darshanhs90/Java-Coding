package Dec2020Leetcode;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class _0726NumberOfAtoms {
	public static void main(String[] args) {
		System.out.println(countOfAtoms("H2O"));
		System.out.println(countOfAtoms("Mg(OH)2"));
		System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
		System.out.println(countOfAtoms("Be32"));
	}

	public static String countOfAtoms(String formula) {
		Stack<TreeMap<String, Integer>> stack = new Stack<TreeMap<String, Integer>>();
		stack.push(new TreeMap<String, Integer>());

		for (int i = 0; i < formula.length();) {
			char c = formula.charAt(i);
			if (c == '(') {
				stack.push(new TreeMap<String, Integer>());
				i++;
			} else if (c == ')') {
				TreeMap<String, Integer> top = stack.pop();
				String str = "";
				while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
					str += formula.charAt(i + 1);
					i++;
				}
				int multiplier = str.length() == 0 ? 1 : Integer.parseInt(str);

				for (Map.Entry<String, Integer> entry : top.entrySet()) {
					String key = entry.getKey();
					Integer val = entry.getValue() * multiplier;
					stack.peek().compute(key, (k, v) -> v == null ? val : v + val);
				}
				i++;

			} else {
				String str = c + "";
				i++;
				while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
					str += formula.charAt(i);
					i++;
				}

				String multString = "";
				while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
					multString += formula.charAt(i);
					i++;
				}
				int multiplier = multString.length() == 0 ? 1 : Integer.parseInt(multString);
				stack.peek().compute(str, (k, v) -> v == null ? multiplier : v + multiplier);
			}
		}

		StringBuilder ans = new StringBuilder();
		for (String name : stack.peek().keySet()) {
			ans.append(name);
			int multiplicity = stack.peek().get(name);
			if (multiplicity > 1)
				ans.append("" + multiplicity);
		}
		return new String(ans);
	}

}
