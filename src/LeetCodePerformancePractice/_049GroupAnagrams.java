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
		HashMap<String, List<String>> map=new HashMap<>();
		List<List<String>> outputList=new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			String str=strs[i];
			char c[]=new char[26];
			for (int j = 0; j < str.length(); j++) {
				c[str.charAt(j)-97]++;
			}
			String key=new String(c);
			if(map.containsKey(key))
			{
				map.get(key).add(str);
			}
			else{
				List<String> list=new ArrayList<>();
				list.add(str);
				map.put(key,list);
			}
		}
		Iterator itr=map.values().iterator();
		while(itr.hasNext())
		{
			outputList.add((List<String>) itr.next());
		}
		return outputList;	
	}
}

