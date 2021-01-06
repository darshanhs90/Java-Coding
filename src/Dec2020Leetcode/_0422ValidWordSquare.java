package Dec2020Leetcode;

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
		if (words == null || words.size() == 0) {
			return true;
		}
		int n = words.size();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < words.get(i).length(); j++) {
				if (j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
					return false;
			}
		}
		return true;
	}

	public static boolean validWordSquare1(List<String> words) {
		if (words == null || words.size() == 0)
			return true;
		int row = 0, col = 0;
		while (row < words.size()) {
			int currCol = col;
			String word = words.get(row);
			// System.out.println(word + "<row>" + row + "<col>" + currCol);
			for (int i = row; i < words.size(); i++) {
				if (currCol < word.length() - 1 && col < words.get(i).length()) {
					if (words.get(i).charAt(col) != word.charAt(currCol))
						return false;
					currCol++;
				} else {
					if (currCol >= word.length() && col < words.get(i).length())
						return false;
					currCol++;
				}
			}

			row++;
			col++;
		}
		return true;
	}

}
