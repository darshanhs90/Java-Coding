package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0736ParseLispExpression {
	public static void main(String[] args) {
		System.out.println(evaluate("(add 1 2)"));
		System.out.println(evaluate("(mult 3 (add 2 3))"));
		System.out.println(evaluate("(let x 2 (mult x 5))"));
		System.out.println(evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
		System.out.println(evaluate("(let x 3 x 2 x)"));
		System.out.println(evaluate("(let x 1 y 2 x (add x y) (add x y))"));
		System.out.println(evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
		System.out.println(evaluate("(let a1 3 b2 (add a1 1) b2)"));
	}

	public static int evaluate(String expression) {
		return calc(expression, new HashMap<String, Integer>());
	}

	public static int calc(String expression, HashMap<String, Integer> parentMap) {
		char c = expression.charAt(0);
		if (c != '(') {
			if (Character.isDigit(c) || c == '-') {
				return Integer.parseInt(expression);
			}
			// c ==')'
			return parentMap.get(expression);
		}

		// remove ( and )
		String str = expression.substring(1, expression.length() - 1);
		c = str.charAt(0);
		HashMap<String, Integer> currMap = new HashMap<String, Integer>();
		currMap.putAll(parentMap);

		List<String> tokens = parse(str);
		if (c == 'a') {// add
			return calc(tokens.get(1), currMap) + calc(tokens.get(2), currMap);
		} else if (c == 'm') {
			// mult
			return calc(tokens.get(1), currMap) * calc(tokens.get(2), currMap);
		} else {
			// let
			for (int i = 1; i < tokens.size() - 1; i += 2) {
				currMap.put(tokens.get(i), calc(tokens.get(i + 1), currMap));
			}
			return calc(tokens.get(tokens.size() - 1), currMap);
		}
	}

	public static List<String> parse(String str) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;
			}

			if (count == 0 && c == ' ') {
				list.add(sb.toString());
				sb = new StringBuilder();
			} else {
				sb.append(c);
			}
		}
		if (sb.length() != 0)
			list.add(sb.toString());
		return list;
	}
}
