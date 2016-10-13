package PracticeLeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _127WordLadder {
	public static void main(String[] args) {
		Set<String> set=new HashSet<>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		System.out.println(ladderLength("hit", "cog", set));//5
	}a
	static class WordNode{
		String word;
		int steps;
		public WordNode(String word,int steps) {
			this.word=word;
			this.steps=steps;
		}
	}

	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		wordList.add(endWord);
		Queue<WordNode> queue=new LinkedList<>();
		queue.add(new WordNode(beginWord, 1));
		while(!queue.isEmpty())
		{
			WordNode w=queue.poll();
			if(w.word.contentEquals(endWord))
			{
				return w.steps;
			}
			char[] cArr=w.word.toCharArray();
			for (int i = 0; i < cArr.length; i++) {
				for (char c='a';c<='z';c++) {
					char temp=cArr[i];
					if(temp!=c)
					{
						cArr[i]=c;
					}
					String newWord=new String(cArr);
					if(wordList.contains(newWord))
					{
						queue.add(new WordNode(newWord, w.steps+1));
						wordList.remove(newWord);
					}
					cArr[i]=temp;
				}
			}
		}
		return 0;
	}
}
