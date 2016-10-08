package PracticeLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class _049GroupAnagrams {
	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> outputList=new ArrayList<>();
		HashMap<String, List<String>> map=new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] c=new char[26];
			String str=strs[i];
			for (int j = 0; j < str.length(); j++) {
				c[str.charAt(j)-'a']++;
			}
			String charString=new String(c);
			if(map.containsKey(charString))
			{
				map.get(charString).add(str);
			}
			else{
				List<String> list=new ArrayList<>();
				list.add(str);
				map.put(charString, list);
			}
		}
		Iterator<List<String>> itr=map.values().iterator();
		while(itr.hasNext())
		{
			outputList.add(itr.next());
		}
		return outputList;
	}
}

