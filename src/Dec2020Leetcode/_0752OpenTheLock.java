package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0752OpenTheLock {
	public static void main(String[] args) {
		System.out.println(openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202"));
		System.out.println(openLock(new String[] { "8888" }, "0009"));
		System.out.println(
				openLock(new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" }, "8888"));
		System.out.println(openLock(new String[] { "0000" }, "8888"));
	}

	public static int openLock(String[] deadends, String target) {
		HashSet<String> deads = new HashSet<String>(new ArrayList<String>(Arrays.asList(deadends)));
		HashSet<String> visited = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		q.offer("0000");
		visited.add("0000");
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String poll = q.poll();
				if (deads.contains(poll)) {
					continue;
				}

				if (poll.equals(target))
					return count;

				char[] cArr = poll.toCharArray();
				for (int j = 0; j < 4; j++) {
					char originalChar = cArr[j];

					int val = originalChar - '0';
					int nextVal = val == 9 ? 0 : val + 1;
					int prevVal = val == 0 ? 9 : val - 1;

					char newNextChar = (char) ('0' + nextVal);
					cArr[j] = newNextChar;
					String nextString = new String(cArr);
					if (!visited.contains(nextString) && !deads.contains(nextString)) {
						q.offer(nextString);
						visited.add(nextString);
					}

					char newPrevChar = (char) ('0' + prevVal);
					cArr[j] = newPrevChar;
					String prevString = new String(cArr);
					if (!visited.contains(prevString) && !deads.contains(prevString)) {
						q.offer(prevString);
						visited.add(prevString);
					}
					cArr[j] = originalChar;
				}
			}
			count++;
		}
		return -1;
	}
}
