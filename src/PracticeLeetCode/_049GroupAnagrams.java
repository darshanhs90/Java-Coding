package PracticeLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _049GroupAnagrams {
	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> outputList=new ArrayList<>();
		HashMap<String, List<String>> map=new HashMap<>();
		char[] arr=new char[26];
		for (int i = 0; i < strs.length; i++) {
			String str=strs[i];
			arr=new char[26];
			for (int j = 0; j < str.length(); j++) {
				arr[str.charAt(j)-97]++;
			}
			String s=new String(arr);
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
		Object[] listArray=map.values().toArray();
		for (int i = 0; i < listArray.length; i++) {
			outputList.add((List<String>) listArray[i]);
		}
		return outputList;
	}
}

