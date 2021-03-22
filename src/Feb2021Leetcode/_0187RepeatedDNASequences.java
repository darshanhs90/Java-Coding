package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _0187RepeatedDNASequences {

	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
	}

	public static List<String> findRepeatedDnaSequences(String s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashSet<String> output = new HashSet<String>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String str = s.substring(i, i + 10);
			map.compute(str, (k, v) -> v == null ? 1 : v + 1);

			if (map.get(str) > 1)
				output.add(str);
		}
		return new ArrayList<String>(output);
	}

}
