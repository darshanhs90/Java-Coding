package PracticeLeetCode;

import java.util.HashMap;

public class _290WordPattern {
	public static void main(String[] args) {
		System.out.println(wordPattern("jquery", "jquery"));
		System.out.println(wordPattern("e", "jquery"));
	}
	public static boolean wordPattern(String pattern, String str) {
		if(pattern==null||str==null||pattern.length()==0||str.length()==0)
			return false;
		String strArr[]=str.split(" ");
		if(strArr.length!=pattern.length())
			return false;
		HashMap<Character, String> map=new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char c=pattern.charAt(i);
			if(map.containsKey(c))
			{
				if(!(map.get(c).contentEquals(strArr[i])))
				{
					return false;
				}
			}
			else{
				if(map.containsValue(strArr[i]))
					return false;
				map.put(c, strArr[i]);
			}
		}
		return true;
	}
}
