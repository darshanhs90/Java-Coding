package eBayPrep;

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
		System.out.println(ladderLength("hit", "cog", set));
		set=new HashSet<>();
		set.add("a");
		set.add("b");
		set.add("c");
		System.out.println(ladderLength("a", "c", set));
		set=new HashSet<>();
		set.add("hot");
		set.add("dog");
		set.add("dot");
		System.out.println(ladderLength("hot", "dog", set));
	}
	static class WordNode{
		String word;
		int numSteps;

		public WordNode(String word, int numSteps){
			this.word = word;
			this.numSteps = numSteps;
		}
	}

	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Queue<WordNode> queue=new LinkedList<>();
		wordList.add(endWord);
		queue.add(new WordNode(beginWord, 1));
		while(!queue.isEmpty())
		{
			WordNode wordNode=queue.remove();
			if(wordNode.word.equals(endWord))
				return wordNode.numSteps;
			String currWord=wordNode.word;
			for (int i = 0; i < currWord.length(); i++) {
				for (char c = 'a'; c < 'z'; c++) {
					String newWord=currWord.substring(0, i)+c+currWord.substring(i+1);
					if(wordList.contains(newWord))
					{
						queue.add(new WordNode(newWord, wordNode.numSteps+1));
						wordList.remove(newWord);
					}	
				}	
			}
		}
		return 0;
	}


	/*	 static int outputVal=Integer.MAX_VALUE;
		public static int ladderLengthNew(String beginWord, String endWord, Set<String> wordList,int currLength) {
			wordList.remove(beginWord);
			if(beginWord.contentEquals(endWord))
				return currLength+1;
			wordList.add(endWord);
			for (int i = 0; i < beginWord.length(); i++) {
				for (char c='a'; c < 'z'; c++) {
					String currWord=beginWord.substring(0,i)+c+beginWord.substring(i+1);
					if(wordList.contains(currWord)){
						System.out.println(currWord);
						wordList.remove(currWord);
						outputVal=Math.min(ladderLengthNew(currWord, endWord, wordList,currLength+1),outputVal);
						System.out.println(outputVal+"*****");
					}
				}
			}
			return Integer.MAX_VALUE;
		}*/
}

