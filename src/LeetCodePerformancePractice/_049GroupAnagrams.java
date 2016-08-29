package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class _049GroupAnagrams {
	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> outputList=new ArrayList<List<String>>();
		if(strs==null||strs.length==0)
			return outputList;
		HashMap<String, List<String>> map=new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			char c[]=new char[26];
			String str=strs[i];
			for (int j = 0; j < str.length(); j++) {
				c[str.charAt(j)-97]++;
			}
			String s=new String(c);
			if(map.containsKey(s))
			{
				map.get(s).add(str);
			}
			else
			{
				List<String> list=new ArrayList<>();
				list.add(str);
				map.put(s,list);
			}
		}
		Iterator itr=map.values().iterator();
		while(itr.hasNext())
			outputList.add((List<String>) itr.next());
		return outputList;
	}
}

