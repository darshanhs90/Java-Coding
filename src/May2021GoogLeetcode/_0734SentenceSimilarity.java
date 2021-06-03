package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _0734SentenceSimilarity {
	public static void main(String[] args) {
		System.out.println(areSentencesSimilar(new String[] { "great", "acting", "skills" },
				new String[] { "fine", "drama", "talent" },
				new ArrayList<List<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList("great", "fine")),
						new ArrayList<String>(Arrays.asList("drama", "acting")),
						new ArrayList<String>(Arrays.asList("skills", "talent"))))));
	}

	public static boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

	}
}
