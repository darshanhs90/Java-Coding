package May2021GoogLeetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class _0681NextClosestTime {

	public static void main(String[] args) {
		System.out.println(nextClosestTime("19:34"));
		System.out.println(nextClosestTime("23:59"));
	}

	public static String nextClosestTime(String time) {
		char[] res = time.toCharArray();
		Character[] digits = new Character[] { res[0], res[1], res[3], res[4] };
		TreeSet<Character> set = new TreeSet<Character>(Arrays.asList(digits));

		res[4] = findNext(res[4], set, '9');
		if (res[4] > time.charAt(4))
			return new String(res);

		res[3] = findNext(res[3], set, '5');
		if (res[3] > time.charAt(3))
			return new String(res);

		res[1] = res[0] == '2' ? findNext(res[1], set, '3') : findNext(res[1], set, '9');
		if (res[1] > time.charAt(1))
			return new String(res);

		res[0] = findNext(res[0], set, '2');
		return new String(res);
	}

	public static char findNext(char c, TreeSet<Character> set, char limit) {
		Character n = set.higher(c);
		return n == null || n > limit ? set.first() : n;
	}

}
