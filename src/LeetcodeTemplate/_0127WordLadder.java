package LeetcodeTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _0127WordLadder {

	public static void main(String[] args) {
		System.out.println(ladderLength("hit", "cog",
				new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));

		System.out.println(
				ladderLength("hit", "cog", new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));

		System.out.println(ladderLength("a", "c", new ArrayList<String>(Arrays.asList("a", "b", "c"))));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		
	}

}
