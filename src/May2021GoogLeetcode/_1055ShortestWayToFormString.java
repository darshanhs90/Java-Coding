package May2021GoogLeetcode;

import java.util.HashSet;

public class _1055ShortestWayToFormString {

	public static void main(String[] args) {
		System.out.println(shortestWay("abc", "abcbc"));
		System.out.println(shortestWay("abc", "acdbc"));
		System.out.println(shortestWay("xyz", "xzyxz"));
	}

	public static int shortestWay(String source, String target) {
		int count = 0;
		HashSet<Character> set1 = new HashSet<Character>();
		HashSet<Character> set2 = new HashSet<Character>();
		for (int i = 0; i < source.length(); i++) {
			set1.add(source.charAt(i));
		}

		for (int i = 0; i < target.length(); i++) {
			set2.add(target.charAt(i));
		}

		if (set1.size() != set2.size())
			return -1;

		int index1 = 0, index2 = 0;
		while (index2 < target.length()) {
			if (index1 == 0)
				count++;
			if (source.charAt(index1) == target.charAt(index2)) {
				index2++;
			}
			index1++;

			if (index1 == source.length())
				index1 = 0;
		}
		return count;
	}
}
