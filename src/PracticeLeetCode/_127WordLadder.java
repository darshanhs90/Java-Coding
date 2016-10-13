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
		int numSteps;
		public WordNode(String word,int numSteps) {
			this.word=word;
			this.numSteps=numSteps;
		}
	}

	private static int  ladderLength(String start, String end, Set<String> set) {
		Queue<WordNode> queue=new LinkedList<>();
		set.add(end);
		queue.add(new WordNode(start, 1));
		while(!queue.isEmpty())
		{
			WordNode w=queue.poll();
			if(w.word.contentEquals(end))
				return w.numSteps;
			char[] currWord=w.word.toCharArray();
			for (int i = 0; i < currWord.length; i++) {
				for (char c = 'a'; c<='z'; c++) {
					char currChar=currWord[i];
					if(currChar!=c)
					{
						currWord[i]=c;
					}

					String newString=new String(currWord);
					if(set.contains(newString))
					{
						set.remove(newString);
						queue.add(new WordNode(newString, w.numSteps+1));
					}
					currWord[i]=currChar;
				}
			}
		}
		return -1;
	}




}
