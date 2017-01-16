package PracticeLeetCode;

import java.util.HashMap;

public class _383RansomNote {
	public static void main(String[] args) {
		System.out.println(canConstruct("a", "z"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}

    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote==null && magazine==null)
        	return true;
        if(ransomNote==null||magazine==null)
        	return false;
        HashMap<Character, Integer> map=new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
			char c=magazine.charAt(i);
			if(map.containsKey(c))
			{
				map.put(c, map.get(c)+1);
			}
			else
			{
				map.put(c, 1);
			}
		}
        for (int i = 0; i < ransomNote.length(); i++) {
			char c=ransomNote.charAt(i);
			if(map.containsKey(c) && map.get(c)>0)
			{
				map.put(c, map.get(c)-1);
			}
			else{
				return false;
			}
		}
        return true;
    }

}
