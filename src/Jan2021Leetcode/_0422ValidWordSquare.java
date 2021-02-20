package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0422ValidWordSquare {

	public static void main(String[] args) {
		System.out.println(validWordSquare(new ArrayList<String>(Arrays.asList("abcd", "bnrt", "crmy", "dtye"))));
		System.out.println(validWordSquare(new ArrayList<String>(Arrays.asList("abcd", "bnrt", "crm", "dt"))));
		System.out.println(validWordSquare(new ArrayList<String>(Arrays.asList("ball", "area", "read", "lady"))));
		System.out.println(validWordSquare(new ArrayList<String>(Arrays.asList("ball", "asee", "let", "lep"))));
		System.out.println(validWordSquare(new ArrayList<String>(Arrays.asList("ball", "asee", "lett", "lep"))));
	}

	public static boolean validWordSquare(List<String> words) {
		if (words == null || words.size() == 0)
			return true;

		for (int i = 0; i < words.size(); i++) {
			String word = words.get(i);
			for (int j = 0; j < word.length(); j++) {

				if (j >= words.size() || words.get(j).length() <= i || words.get(i).charAt(j) != words.get(j).charAt(i))
					return false;
			}
		}
		return true;
	}

}
