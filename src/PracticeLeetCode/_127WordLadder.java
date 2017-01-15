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
	}
	static class WordNode{
		String word;
		int numSteps=0;
		public WordNode(String word,int steps) {
			this.word=word;
			this.numSteps=steps;
		}
	}
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Queue<WordNode> queue=new LinkedList<>();
		wordList.add(endWord);
		queue.add(new WordNode(beginWord, 1));
		while(!queue.isEmpty())
		{
			WordNode top=queue.poll();
			if(top.word.contentEquals(endWord))	
			{
				return top.numSteps;
			}
			String str=top.word;
			char[] c=str.toCharArray();
			for (int i = 0; i < c.length; i++) {
				char temp=c[i];
				for (char c1 = 'a'; c1 <='z'; c1++) {
					if(temp!=c1)
					{
						c[i]=c1;
					}
					if(wordList.contains(new String(c)))
					{
						queue.add(new WordNode(new String(c), top.numSteps+1));
						wordList.remove(new String(c));
					}
				}
				c[i]=temp;
			}
		}
		return 0;
	}


}
