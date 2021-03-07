package Feb2021Leetcode;

import java.util.HashMap;

public class _0091DecodeWays {

	public static void main(String[] args) {
		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("226"));
		System.out.println(numDecodings("0"));
		System.out.println(numDecodings("1"));
		System.out.println(numDecodings("2101"));
		System.out.println(numDecodings("123123"));
	}

	public static int numDecodings(String s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		dfs(0,s,map);
		return map.containsKey(s) ? map.get(s) : 0;
	}
	
	public static int dfs(int index, String s, HashMap<String,Integer> map) {
		if(index == s.length())
		{
			return 1;
		}
		if(index>=s.length())
			return 0;
		
		String subString = s.substring(index);
		if(map.containsKey(subString))
		{
			return map.get(subString);
		}
		
		int count = 0;
		
		if(s.charAt(index) =='0')
		{
			map.put(subString, count);
			return 0;
		}
		else {
			count+= dfs(index+1,s,map);
		}
		
		
		if(index+1<s.length())
		{
			int val = Integer.parseInt(s.charAt(index)+""+s.charAt(index+1));
			
			if(val>=10 && val<=26)
			{
				count+=dfs(index+2,s,map);
			}
		}

		map.put(subString, count);
		return count;
	}
	
	

}
