package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0187RepeatedDNASequences {

	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
	}

	public static List<String> findRepeatedDnaSequences(String s) {
		HashSet<String> visited = new HashSet<String>();
		HashSet<String> out = new HashSet<String>();
		for (int i = 0; i < s.length() - 9; i++) {
			String str = s.substring(i, i + 10);
			if (visited.contains(str)) {
				out.add(str);
			}
			visited.add(str);
		}
		return new ArrayList<String>(out);
	}

}
