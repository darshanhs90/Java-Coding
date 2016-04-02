package Warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;
//not working for third test case
class TrieNode {
	private char charValue;
	private HashMap<Character,TrieNode> children;
	private boolean ended;

	public TrieNode(char ch) {
		charValue = ch;
		children = new HashMap<>();
		ended = false;
	}
	public HashMap<Character,TrieNode> getChildren() 
	{ 
		return children; 
	}
	public char getCharValue()						 
	{
		return charValue;	
	}
	public void setEnded(boolean val)			
	{
		ended = val;	
	}
	public boolean ended()						 
	{
		return ended; 
	}
}


class Trie {
	private TrieNode root;
	public Trie() {	 
		this.root = new TrieNode((char)0);
		System.out.println(this.root.getCharValue());
	} 

	public void insertWord(String newWord) {

		int length = newWord.length();
		TrieNode crawlerNode = root;
		for( int i = 0; i < length; i++)
		{
			HashMap<Character,TrieNode> child = crawlerNode.getChildren();
			char character = newWord.charAt(i);
			if( child.containsKey(character))
				crawlerNode = child.get(character);
			else 
			{
				TrieNode temporaryNode = new TrieNode(character);
				child.put( character, temporaryNode );
				crawlerNode = temporaryNode;
			}
		}
		crawlerNode.setEnded(true);
	}

	public String getPrefixMatch(String inputString) {
		String resultantString = ""; 
		int stringLength = inputString.length();  
		TrieNode crawlerNode = root; 
		int i, prevMatch = 0;
		for( i = 0 ; i < stringLength; i++ )
		{
			char character = inputString.charAt(i); 
			HashMap<Character,TrieNode> child = crawlerNode.getChildren();					 
			if( child.containsKey(character) )
			{
				resultantString += character;		 
				crawlerNode = child.get(character); 
				if( crawlerNode.ended() )
					prevMatch = i + 1;
			}
			else break;
		}
		if( !crawlerNode.ended() )
			return resultantString.substring(0, prevMatch);	 
		else return resultantString;
	}


}

public class _71TrieSnapChat {
	public static void main(String[] args) {
		Trie dict = new Trie();
		//String[] str=new String[]{"chat","ever","snapchat","snap","salesperson","per","person","sales","son","whatsoever","what","so"};
		String[] str=new String[]{"aaaaabababaaabbbababbbaaab",
				"ababbabaa",
				"baaaabbbbabbaabbbaababba",
				"baabaaabaaaaabaaabaaaabbbabbb",
				"aabbb",
				"ababbbaaabaaaaabbbbabaababbbbbabb",
				"bbabbbab",
				"baaa",
				"aabba",
				"aaaaaabaaa",
				"aabaabbbbabbbaabaaaaaaaaaaaa",
				"aaaba",
				"aaababbbabbabaa",
				"aaabb",
				"bbabb",
				"bbabaababaabb",
				"bbbbaabaabaaa",
				"bbaaaaaaa",
				"baab",
				"ababbbabaaaaaa",
				"aabbabbbabbbbabbaaaabaaaba",
				"baaabbbbb",
				"babaababbbabb",
				"bbab",
				"abbbba",
				"bbaa",
				"bbbabbaaaabbbbabbaaabababb",
				"abbbbbabaa",
				"abbabbaaab",
				"babbaabbaaabbbaaaababaaabaaabbba",
				"aaaaaabbbababaaabbb",
				"abbaaaaab",
				"baaabbbbbaabbbaabaaabbbaaaab",
				"abbaaaaabaaabbbaaa",
				"bbaabb",
				"bbbabbaaababaabaabaaababbaabbaa",
				"ababbba",
				"aaabaaaaa",
				"baaaabbbbbaabbbab",
				"aababbababaabbbaab",
				"baabb",
				"ababaabababbaabbaa",
				"abbbbababaabbaaaabbb",
				"aaaaa",
				"baaaabb",
				"baaaaba",
				"abbbaab",
				"abbaababb",
				"bbababaababaaabababbba",
				"aaabaaaabaabbbbbbaaaaaaa",
				"ababb",
				"aaab",
				"aaaa",
				"aaaaaababbbaaaababbaababb",
				"abaa",
				"bb",
				"baaabbababaabbbabaaaababaababaab",
				"bbababa",
				"aaabaabbabbbbaaaaabbb",
				"aabbaabbbabbaababbaabbb",
				"baaabbbbbaabaa",
				"abaaaaaba",
				"abaab",
				"abbb",
				"bbaaabaa",
				"bbabaab",
				"bbbbbbbaaa",
				"abbbaabbbbbab",
				"aabbabbbab",
				"abbabbbaabaabb",
				"bbbbbaaaabbbabaaaabbabbbababbab",
				"aaabaa",
				"bbababaab",
				"baaaabbbb",
				"abbbaabbbabbbababaabaaabaabbababaab",
				"baaaababa",
				"aabaabbbb",
				"ba",
				"baaaabbbbbbababbabaa",
				"abbbaaaab",
				"abbbaababbbbaaababbabaaababbbaaab",
				"aababba",
				"baaaabbbabaaaaababbababaabba",
				"baabbbabbababaaa",
				"aaaaabbabbaaab",
				"aa",
				"ab",
				"abbbaaaabbababaaaaabbabbbabaaaaaaaaaaab",
				"abbabbbbabba",
				"aba",
				"abb",
				"baaabbbbbaaaaaaabaabbbaab",
				"bbbabaababbababbaaaababaab",
				"bba",
				"bbb",
				"baaaabbbbaabbababba",
				"bbaabbaabb",
				"bbbbaabbabbbabaababbabaabaa",
				"aab",
				"bbaabbbba",
				"bbbabbaaaaaaababaababbababaaabbababaab",
				"aaabaaaaabaaaabaabbab",
				"baabbbab",
				"baaaba",
				"babbaaabab",
				"abbabbabbaaabababbbabbababaab",
				"baa",
				"abaabbbaab",
				"bab",
				"baaaabbbbbaabaaaabbaaabbbbbbbbaaa",
				"abbbaababbabbbab",
				"aabaabaaabbbabba",
				"baababaab",
				"aabaabaaa",
				"aaaaaab",
				"abbabaabaabbbbaaabbabbbaab",
				"abbaababbababbbabbaaabaaabbbbb",
				"aababbabaa",
				"abaaaaabaabaaaabaabbbbbbaabbbbbabaa",
				"ababaaaabbb",
				"babbaaaabbb",
				"abaabaaababbababaab",
				"aabaabbbbaabaaaabbbbaaaa",
				"abbbbabab",
				"abbababba",
				"aaaaaaaaaabba",
				"aababbbaababba",
				"abaaab",
				"aababbaabbabbaaabaaaaaaababbabaaaa",
				"ababbaabbabbbabaabbabbbabbaaaaa",
				"ababaaba",
				"aaabaabababaaa",
				"baaaabbb",
				"aaaaaa",
				"bbababaaaab",
				"baaaabbbaabbabbaabbaaabbaaaaab",
				"ababbbaabbbaabbaaabaaaaab",
				"abbab",
				"aaaaaaaaaa",
				"aabaabbbbabbaaaaaabaaabbbbb",
				"aabaa",
				"abbbaaabbaaaabbbbbab",
				"ababaabaababbabbabbabaa",
				"abbbababbbabbbababa",
				"abaabbb",
				"aaabbbabaa",
				"baabbababbbabaab",
				"bbbabaababbbbaaabaabbbbbbbaaab",
				"abbba",
				"babbaabbaa",
				"bbaabaabb",
				"babaabab",
				"ababbabb",
				"bbbabba",
				"babaabba",
				"aaaaaaaaaaabbabbbab",
				"bbbaaabbabbaaaaababbabaaabbbabaa",
				"bbaabbaa",
				"babbb",
				"bbaaaaabaaaaaaaabbbabaa",
				"bbbaaab",
				"aaababbb",
				"ababbbab",
				"bbabbbabaabaabbbb",
				"babbbabbababaababbb",
				"aabaaababbbabaabaabaa",
				"baabbaababbaaababaaabbbababa",
				"babaab",
				"bababaaa",
				"abbaaaaaabbaaba",
				"bbabbabaa",
				"bbbbba",
				"aabbbabaababbabbaaab",
				"ababbbaaab",
				"ababbbabababbaabbababaababbb",
				"abaabbaababbaaabb",
				"aabbabbbabbaabbbabbabaabbbababa",
				"aababbabababaaabbbaaababbab",
				"babaababbb",
				"aaababbbaaaabbbaaabbbaab",
				"aaababbbbaabbbab"};
		
		
		HashMap<Integer, String> pointerMap=new HashMap<>();
		for (int i = 0; i < str.length; i++) {
			pointerMap.put(i, str[i]);
		}
		System.out.println(Arrays.toString(str));
		Arrays.sort(str, new compareStringLength());
		System.out.println(Arrays.toString(str));		
		TreeSet<String> decodedSet=new TreeSet<>();
		TreeSet<String> outputSet=new TreeSet<>();
		for (int i = 0; i < str.length; i++) {
			String a=str[i];
			if(dict.getPrefixMatch(str[i]).contentEquals("")){
				dict.insertWord(str[i]);
			}
			else{
				String input=str[i];
				String match=dict.getPrefixMatch(str[i]);
				ArrayList<String> alist=new ArrayList<>();
				boolean add=true;
				while(!(match.contentEquals(""))){
					alist.add(match);
					input=input.replaceFirst(match, "");
					match=dict.getPrefixMatch(input);
					if(match.contentEquals("") && !input.contentEquals("")){
						add=false;
						break;
					}
					else if(match.contentEquals("") && input.contentEquals("")){
						add=true;
					}
				}
				if(add){
					decodedSet.add(str[i]);
					for (int j = 0; j < alist.size(); j++) {
						if(!decodedSet.contains(alist.get(j))){
							outputSet.add(alist.get(j));
						}
					}
				}
				dict.insertWord(str[i]);
			}
		}
		int counter=0;
		String[] outputArray=new String[outputSet.size()];
		for (int i = 0; i < str.length; i++) {
			if(outputSet.contains(pointerMap.get(i))){
				outputArray[counter]=(pointerMap.get(i));
				counter++;
			}
		}
		System.out.println(Arrays.toString(outputArray));
	}
	public static class compareStringLength implements Comparator<String> {
		public int compare(String s1, String s2) {
			int diff = s1.length() - s2.length();
			return diff != 0? diff: s1.compareTo(s2);
		}
	}
}

