package FacebookPrep;

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
		Stack<TreeMap> stack = new Stack<TreeMap>();
		stack.push(new TreeMap<String, Integer>());

		for (int i = 0; i < formula.length();) {

			char c = formula.charAt(i);
			if (c == '(') {
				stack.push(new TreeMap<String, Integer>());
				i++;
			} else if (c == ')') {
				StringBuilder sb = new StringBuilder();
				if (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
					while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
						sb.append(formula.charAt(i + 1));
						i++;
					}
				}

				int multiplier = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;

				TreeMap<String, Integer> map = stack.pop();
				TreeMap<String, Integer> peekMap = stack.peek();

				for (Map.Entry<String, Integer> entry : map.entrySet()) {
					if (peekMap.containsKey(entry.getKey())) {
						peekMap.put(entry.getKey(), peekMap.get(entry.getKey()) + entry.getValue() * multiplier);
					} else {
						peekMap.put(entry.getKey(), entry.getValue() * multiplier);
					}
				}
				i++;
			} else {

				String element = c + "";
				if (i + 1 < formula.length() && Character.isLowerCase(formula.charAt(i + 1))) {
					element += formula.charAt(i + 1);
					i++;
				}

				String multiplierString = "";
				while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
					multiplierString += formula.charAt(i + 1);
					i++;
				}

				int multiplier = multiplierString.length() > 0 ? Integer.parseInt(multiplierString) : 1;

				TreeMap<String, Integer> peekMap = stack.peek();

				peekMap.compute(element, (key, val) -> val == null ? multiplier : val + multiplier);
				i++;
				// get the element
				// get the count and add it to the stack peek map;
			}
		}

		StringBuilder sb = new StringBuilder();
		TreeMap<String, Integer> peekMap = stack.peek();
		for (Map.Entry<String, Integer> entry : peekMap.entrySet()) {
			sb.append(entry.getKey());
			if (entry.getValue() != 1)
				sb.append(entry.getValue());
		}
		return sb.toString();
	}

}
