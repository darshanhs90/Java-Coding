package LeetcodeTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class _0642DesignSearchAutocompleteSystem {

	public static void main(String[] args) {
		AutocompleteSystem acs = new AutocompleteSystem(
				new String[] { "i love you", "island", "ironman", "i love leetcode" }, new int[] { 5, 3, 2, 2 });

		System.out.println(acs.input('i'));
		System.out.println(acs.input(' '));
		System.out.println(acs.input('a'));
		System.out.println(acs.input('#'));
		System.out.println(acs.input('i'));
		System.out.println(acs.input(' '));
		System.out.println(acs.input('a'));
		System.out.println(acs.input('#'));
		System.out.println(acs.input('i'));
		System.out.println(acs.input(' '));
		System.out.println(acs.input('a'));
		System.out.println(acs.input('#'));
		System.out.println(acs.input('i'));
	}

	static class AutocompleteSystem {
	
		public AutocompleteSystem(String[] sentences, int[] times) {
			
		}

		public List<String> input(char c) {
			
		}
	}
}
