package Jan2021Leetcode;

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
		HashSet<String> mainSet = new HashSet<String>();
		HashSet<String> outSet = new HashSet<String>();
		List<String> out = new ArrayList<String>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String str = s.substring(i, i + 10);
			if (mainSet.contains(str) && !outSet.contains(str)) {
				outSet.add(str);
				out.add(str);
			}
			mainSet.add(str);
		}
		return out;
	}

}
