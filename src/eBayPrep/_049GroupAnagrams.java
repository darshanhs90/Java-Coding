package eBayPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _049GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}

	static HashMap<String,ArrayList<String>> outputMap;
	public static List<List<String>> groupAnagrams(String[] strs) {
		outputMap=new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char arr[]=new char[26];
			String str=strs[i];
			for (int j = 0; j < str.length(); j++) {
				arr[str.charAt(j)-'a']++;
			}
	        String string = new String(arr);
	        if(outputMap.containsKey(string))
	        {
	        	ArrayList<String> aList=outputMap.get(string);
	        	aList.add(str);
	        	outputMap.put(string, aList);
	        }
	        else{
	        	ArrayList<String> aList=new ArrayList<>();
	        	aList.add(str);
	        	outputMap.put(string, aList);
	        }
		}
		List<List<String>> outputList=new ArrayList<>();
		outputList.addAll(outputMap.values());
		return outputList;
	}
	public static List<List<String>> groupAnagrams2(String[] strs) {
		outputMap=new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char c[]=strs[i].toCharArray();
			Arrays.sort(c);
			String string=new String(c);
	        if(outputMap.containsKey(string))
	        {
	        	ArrayList<String> aList=outputMap.get(string);
	        	aList.add(strs[i]);
	        	outputMap.put(string, aList);
	        }
	        else{
	        	ArrayList<String> aList=new ArrayList<>();
	        	aList.add(strs[i]);
	        	outputMap.put(string, aList);
	        }
		}
		List<List<String>> outputList=new ArrayList<>();
		outputList.addAll(outputMap.values());
		System.out.println(outputList);
		return outputList;
	}


}

