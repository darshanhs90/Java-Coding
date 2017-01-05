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
	private static int ladderLength(String start, String end, Set<String> set) {
		Queue<WordNode> queue=new LinkedList<>();
		set.add(end);
		queue.add(new WordNode(start, 1));
		while(!queue.isEmpty())
		{
			WordNode newWord=queue.poll();
			if(newWord.word.contentEquals(end))
				return newWord.numSteps;
			String str=newWord.word;
			char[] c=str.toCharArray();
			for (int i = 0; i < c.length; i++) {
				char temp=c[i];
				for (char j = 'a'; j <='z'; j++) {
					if(c[i]!=j)
						c[i]=j;
					if(set.contains(new String(c)))
					{
						queue.add(new WordNode(new String(c), newWord.numSteps+1));
						set.remove(new String(c));
					}
					c[i]=temp;
				}
			}
		}
		return 0;
	}




}
