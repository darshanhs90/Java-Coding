package LeetCodePractice;

import java.util.HashSet;
import java.util.Set;

public class _139WordBreak {

	public static void main(String[] args) {
		Set<String> set=new HashSet<>();
		set.add("aaaa");
		set.add("aaa");
		System.out.println(wordBreak("leetcode", set));
	}
	public static boolean wordBreak(String s, Set<String> wordDict) {
		int index=0;
		while(s.length()>0)
		{	
			if(index>s.length())
				return false;
			if(wordDict.contains(s.substring(0,index))){
				s=s.substring(index);
				index=0;
			}
			else{
				index++;
			}
		}
		return true;
	}
}

