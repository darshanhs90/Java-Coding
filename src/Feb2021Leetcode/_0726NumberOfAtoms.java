package Feb2021Leetcode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class _0726NumberOfAtoms {
	public static void main(String[] args) {
		System.out.println(countOfAtoms("H2O"));
		System.out.println(countOfAtoms("Mg(OH)2"));
		System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
		System.out.println(countOfAtoms("Be32"));
	}

	public static String countOfAtoms(String formula) {
		Queue<Character> q = new LinkedList<Character>();
		for (int i = 0; i < formula.length(); i++) {
			q.offer(formula.charAt(i));
		}

		TreeMap<String, Integer> map = calculate(q);
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			sb.append(entry.getKey());
			if (entry.getValue() > 1)
				sb.append(entry.getValue());
		}
		return sb.toString();
	}

	public static TreeMap<String, Integer> calculate(Queue<Character> q) {
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		String currElement = "";
		while (!q.isEmpty()) {
			char c = q.poll();
			if (Character.isAlphabetic(c)) {
				if (currElement != "")
					map.compute(currElement, (k, v) -> v == null ? 1 : v + 1);
				currElement = c + "" + getCurrElement(q);
			} else if (Character.isDigit(c)) {
				String str = c + "";
				while (!q.isEmpty() && Character.isDigit(q.peek())) {
					str += q.poll();
				}
				int mult = Integer.parseInt(str);
				map.compute(currElement, (k, v) -> v == null ? mult : v + mult);
				currElement = "";
			} else if (c == '(') {
				if (currElement != "")
					map.compute(currElement, (k, v) -> v == null ? 1 : v + 1);

				TreeMap<String, Integer> newMap = calculate(q);
				currElement = "";
				String str = "";
				while (!q.isEmpty() && Character.isDigit(q.peek())) {
					str += q.poll();
				}
				Integer multVal = str.length() != 0 ? Integer.parseInt(str) : 1;
				for (Map.Entry<String, Integer> entry : newMap.entrySet()) {
					map.compute(entry.getKey(),
							(k, v) -> v == null ? multVal * entry.getValue() : v + multVal * entry.getValue());
				}

			} else if (c == ')') {
				if (currElement != "")
					map.compute(currElement, (k, v) -> v == null ? 1 : v + 1);
				return map;
			}
		}
		if (currElement != "")
			map.compute(currElement, (k, v) -> v == null ? 1 : v + 1);
		return map;
	}

	public static String getCurrElement(Queue<Character> q) {
		if (!q.isEmpty() && Character.isLowerCase(q.peek())) {
			return q.poll() + "";
		}
		return "";
	}

}
