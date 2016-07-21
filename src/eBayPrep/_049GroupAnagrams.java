package LeetCodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class _049GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> outputList=new ArrayList<>();
		HashMap<String,List<String>> stringtoIndexMap=new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] c=strs[i].toCharArray();
			Arrays.sort(c);
			String st=new String(c);
			if(stringtoIndexMap.containsKey(st))
			{//get index and add to that list
				List<String> list=stringtoIndexMap.get(st);
				list.add(strs[i]);
				stringtoIndexMap.put(st, list);
			}
			else{//create new list
				List<String> list=new ArrayList<>();;
				list.add(strs[i]);
				stringtoIndexMap.put(st, list);
			}		
		}	

		Map<String, List<String>> map = stringtoIndexMap;
		for (Entry<String, List<String>> entry : map.entrySet())
		{
			outputList.add(entry.getValue());
		}
		return outputList;
	}
}

