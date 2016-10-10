package PracticeLeetCode;

import java.util.HashMap;

public class _290WordPattern {
	public static void main(String[] args) {
		System.out.println(wordPattern("jquery", "jquery"));
		System.out.println(wordPattern("e", "jquery"));
	}
	public static boolean wordPattern(String pattern, String str) {
		String arr[]=str.split(" ");
		if(arr.length!=pattern.length())
			return false;
		HashMap<Character, String> map=new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char c=pattern.charAt(i);
			if(map.containsKey(c))
			{
				if(!map.get(c).equals(arr[i]))
					return false;
			}
			else{
				if(map.containsValue(arr[i]))
					return false;
				map.put(c, arr[i]);
			}
		}
		return true;
	}
}
