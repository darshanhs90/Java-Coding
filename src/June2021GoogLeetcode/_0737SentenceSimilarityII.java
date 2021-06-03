package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _0737SentenceSimilarityII {
	public static void main(String[] args) {
		System.out.println(areSentencesSimilarTwo(new String[] { "great", "acting", "skills" },
				new String[] { "fine", "drama", "talent" },
				new ArrayList<List<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList("great", "good")),
						new ArrayList<String>(Arrays.asList("fine", "good")),
						new ArrayList<String>(Arrays.asList("acting", "drama")),
						new ArrayList<String>(Arrays.asList("skills", "talent"))))));
	}

	public static boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
		
	}
}
