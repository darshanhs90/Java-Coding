package PracticeLeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _387FirstUniqueCharacterInString {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
	}

	public static int firstUniqChar(String s) {
		Queue<Character> q = new LinkedList<Character>();
		HashMap<Character, Integer> set = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.containsKey(c)) {
				q.remove(c);
			} else {
				set.put(c, i);
				q.add(c);
			}
		}
		return q.isEmpty() ? -1 : set.get(q.peek());
	}

}
