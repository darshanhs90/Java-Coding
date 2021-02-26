package FacebookPrep;

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
		HashSet<String> wordSet = new HashSet<String>(wordList);
		if(!wordSet.contains(endWord) || beginWord.equals(endWord))
			return 0;
		Queue<String> q = new LinkedList<String>();
		int count = 1;
		q.offer(beginWord);
		while(!q.isEmpty())
		{
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String word = q.poll();
				if(word.equals(endWord))
					return count;
				
				char[] cArr = word.toCharArray();
				for (int j = 0; j < cArr.length; j++) {
					char originalChar = cArr[j];
					for (char c = 'a'; c <= 'z'; c++) {
						cArr[j] = c;
						String newWord = new String(cArr);
						if(wordSet.contains(newWord))
						{
							q.offer(newWord);
							wordSet.remove(newWord);
						}
					}
					cArr[j] = originalChar;
				}
			}
			count++;
		}
		return 0;
	}

}
