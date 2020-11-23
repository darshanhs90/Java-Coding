package Nov2020Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _0387FirstUniqueCharacterInAString {

	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
	}

	public static int firstUniqChar(String s) {
		Queue<Character> queue = new LinkedList<Character>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				if (queue.contains(c))
					queue.remove(c);
			} else {
				map.put(c, i);
				queue.offer(c);
			}
		}
		return queue.isEmpty() ? -1 : map.get(queue.peek());
	}
}
