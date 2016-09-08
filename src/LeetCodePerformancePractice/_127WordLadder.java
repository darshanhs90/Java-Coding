package LeetCodePerformancePractice;

import java.util.HashSet;
import java.util.Set;

public class _127WordLadder {
	public static void main(String[] args) {
		Set<String> set=new HashSet<>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		System.out.println(ladderLength("hit", "cog", set));
	}
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	}
}
