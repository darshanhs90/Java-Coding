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
		List<List<String>> list=new ArrayList<>();
		if(strs==null||strs.length==0)
			return list;
		HashMap<String, List<String>> map=new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String str=strs[i];
			char[] cArr=new char[26];
			for (int j = 0; j < str.length(); j++) {
				cArr[str.charAt(j)-97]++;
			}
			String newString=new String(cArr);
			if(map.containsKey(newString))
			{
				map.get(newString).add(str);
			}
			else{
				List<String> newList=new ArrayList<>();
				newList.add(str);
				map.put(newString, newList);
			}
		}
		Iterator<List<String>> itr=map.values().iterator();
		while(itr.hasNext()){
			list.add(itr.next());
		}
		return list;
	}
}

