package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class _0316RemoveDuplicateLetters {

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}

	public static String removeDuplicateLetters(String s) {
		HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.get(c).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(c, list);
			}
		}

		HashSet<Character> seen = new HashSet<Character>();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(c);
				map.get(c).remove(0);
				seen.add(c);
			} else {
				if (!seen.contains(c)) {
					if (stack.peek() > c && map.get(stack.peek()).size() > 0) {
						while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()).size() > 0) {
							Character element = stack.pop();
							seen.remove(element);
						}
						map.get(c).remove(0);
						stack.push(c);
						seen.add(c);

					} else {
						map.get(c).remove(0);
						stack.push(c);
						seen.add(c);
					}
				} else {
					map.get(c).remove(0);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}
}
