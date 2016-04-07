package TopCoder;

import java.util.HashMap;

/*
 * SRM 160 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1333&rd=4605
 */



public class SRM160Substitute {
	public static void main(String[] args)  {
		System.out.println(getValue("TRADINGFEW","LGXWEV"));
		System.out.println(getValue("ABCDEFGHIJ","XJ"));
		System.out.println(getValue("CRYSTALBUM","MMA"));
	}
	public static int getValue(String key, String code){
		HashMap<Character, Integer> charMap=new HashMap<>();
		for (int i = 0; i < key.length(); i++) {
			charMap.put(key.charAt(i), i+1);
		}
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < code.length(); i++) {
			if(charMap.containsKey(code.charAt(i))){
				int value=charMap.get(code.charAt(i));
				if(value==10)
					value=0;
				sb.append(value);
			}
		}
		return Integer.parseInt(sb.toString());
	}
}
