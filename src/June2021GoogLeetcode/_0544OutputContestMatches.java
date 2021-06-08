package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0544OutputContestMatches {

	public static void main(String[] args) {
		System.out.println(findContestMatch(2));
		System.out.println(findContestMatch(4));
		System.out.println(findContestMatch(8));
	}

	public static String findContestMatch(int n) {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			list.add(i + "");
		}

		return helper(list);
	}

	public static String helper(List<String> list) {
		if (list.size() == 1)
			return list.get(0);

		List<String> newList = new ArrayList<String>();
		int size = list.size();
		for (int i = 0; i < size / 2; i++) {
			newList.add("(" + list.get(i) + "," + list.get(size - i - 1) + ")");
		}
		return helper(newList);
	}

}
