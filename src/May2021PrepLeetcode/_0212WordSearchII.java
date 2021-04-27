package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0212WordSearchII {

	public static void main(String[] args) {
		System.out.println(findWords(
				new char[][] { new char[] { 'o', 'a', 'a', 'n' }, new char[] { 'e', 't', 'a', 'e' },
						new char[] { 'i', 'h', 'k', 'r' }, new char[] { 'i', 'f', 'l', 'v' } },
				new String[] { "oath", "pea", "eat", "rain" }));

		System.out.println(
				findWords(new char[][] { new char[] { 'a', 'b' }, new char[] { 'c', 'd' } }, new String[] { "abcb" }));

	}

	public static List<String> findWords(char[][] board, String[] words) {
		
	}

}
