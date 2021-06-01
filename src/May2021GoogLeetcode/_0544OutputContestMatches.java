package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0544OutputContestMatches {

	public static void main(String[] args) {
		System.out.println(findContestMatch(2));
		System.out.println(findContestMatch(4));
		System.out.println(findContestMatch(8));
	}

	public static String findContestMatch(int n) {
		List<String> output = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			output.add(String.valueOf(i));
		}

		while (output.size() != 1) {
			List<String> newList = new ArrayList<String>();
			for (int i = 0; i < output.size() / 2; i++) {
				newList.add("(" + output.get(i) + "," + output.get(output.size() - i - 1) + ")");
			}
			output = newList;
		}
		return String.join("", output);
	}

}
