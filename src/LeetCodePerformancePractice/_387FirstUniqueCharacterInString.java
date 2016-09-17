package LeetCodePerformancePractice;

import java.util.HashSet;
import java.util.Set;

public class _387FirstUniqueCharacterInString {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));
	}
	public static int firstUniqChar(String s) {
		Set<Character> set=new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(s.lastIndexOf(c)==i && !set.contains(c))
				return i;
			set.add(c);
		}
		return -1;
	}
}
