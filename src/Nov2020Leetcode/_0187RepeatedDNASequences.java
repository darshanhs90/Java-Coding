package Nov2020Leetcode;

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
		List<String> list = new ArrayList<String>();
		if (s.length() <= 10) {
			return list;
		}
		HashSet<String> set = new HashSet<String>();

		for (int i = 0; i <= s.length() - 10; i++) {
			String str = s.substring(i, i + 10);
			if (set.contains(str) && !list.contains(str)) {
				list.add(str);
			}
			set.add(str);
		}
		return list;
	}

}
