package TopCoder;

import java.util.HashMap;

/*
 * SRM 158 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1791&rd=4598
 */



public class SRM158TireRotation {
	public static void main(String[] args)  {
		System.out.println(getCycle("ABCD","ABCD"));
		System.out.println(getCycle("ABCD","DCAB"));
		System.out.println(getCycle("ABCD","CDBA"));
		System.out.println(getCycle("ABCD","ABDC"));
		System.out.println(getCycle("ZAXN","XNAZ"));
	}
	public static int getCycle(String initial, String current){
		HashMap<Character, Character> charMap=new HashMap<>();
		int x=(int)'A';
		for (int i = 0; i < initial.length(); i++) {
			charMap.put(initial.charAt(i),(char)x);
			x++;
		}
		StringBuilder currString=new StringBuilder();
		for (int i = 0; i < current.length(); i++) {
			currString.append(charMap.get(current.charAt(i)));
		}
		current=currString.toString();
		if(current.contentEquals("ABCD")){
			return 1;
		}else if(current.contentEquals("DCAB")){
			return 2;
		}else if(current.contentEquals("BADC")){
			return 3;
		}else if(current.contentEquals("CDBA")){
			return 4;
		}
		return -1;
	}
}
