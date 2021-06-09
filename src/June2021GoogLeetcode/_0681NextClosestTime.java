package June2021GoogLeetcode;

import java.util.TreeSet;

public class _0681NextClosestTime {

	public static void main(String[] args) {
		System.out.println(nextClosestTime("19:34"));
		System.out.println(nextClosestTime("23:59"));
	}

	public static String nextClosestTime(String time) {
		char[] cArr = time.toCharArray();
		TreeSet<Character> set = new TreeSet<Character>();
		set.add(cArr[0]);
		set.add(cArr[1]);
		set.add(cArr[2]);
		set.add(cArr[3]);

		cArr[4] = findNext(cArr[4], '9', set);
		if (cArr[4] > time.charAt(4)) {
			return new String(cArr);
		}

		cArr[3] = findNext(cArr[3], '5', set);
		if (cArr[3] > time.charAt(3)) {
			return new String(cArr);
		}

		cArr[1] = findNext(cArr[1], cArr[0] == '2' ? '3' : '9', set);
		if (cArr[1] > time.charAt(1)) {
			return new String(cArr);
		}
		cArr[0] = findNext(cArr[0], '2', set);
		return new String(cArr);
	}

	public static char findNext(char c, char limit, TreeSet<Character> set) {
		char out = c;
		for (out = '9'; out >= '0'; out--) {
			if (out > c && out <= limit && set.contains(out)) {
				return out;
			}
		}
		return set.first();
	}

}
