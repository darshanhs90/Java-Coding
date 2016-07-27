package eBayPrep;

import java.util.HashSet;
import java.util.Set;

public class _139WordBreak {

	public static void main(String[] args) {
		Set<String> set=new HashSet<>();
		set.add("aaaa");
		set.add("aaa");
		System.out.println(wordBreak("aaaaaaa", set));
		set=new HashSet<>();
		set.add("leet");
		set.add("code");
		System.out.println(wordBreak("leetcode", set));
		
	}
	public static boolean wordBreak(String s, Set<String> wordDict) {
		if(s.length()==0)
			return true;
		boolean helper[]=new boolean[s.length()];
		boolean foundTrue=false;
		for (int i = 0; i < helper.length; i++) {
			String word=s.substring(0,i+1);
			if(wordDict.contains(word)){
				helper[i]=true;
				foundTrue=true;
			}
		}
		if(!foundTrue)return false;
		boolean output=false;
		for (int i = 0; i < helper.length; i++) {
			if(helper[i])
				output|=wordBreak(s.substring(i+1), wordDict);
		}
		return output;
	}
}

