package PracticeLeetCode;

import java.util.HashMap;

public class _205IsomorphicStrings {


	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg","add"));
		System.out.println(isIsomorphic("foo","bar"));
		System.out.println(isIsomorphic("paper","title"));
	}

    public static boolean isIsomorphic(String s, String t) {
        if(s==null && t==null)
        	return true;
        if(s==null||t==null||s.length()!=t.length())
        	return false;
        HashMap<Character, Character> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	char c1=s.charAt(i);
        	char c2=t.charAt(i);
			if(map.containsKey(c1)){
				if(map.get(c1)!=c2)
					return false;
			}else{
				if(map.containsValue(c2))
					return false;
				map.put(c1, c2);
			}
		}
        return true;
    }
}