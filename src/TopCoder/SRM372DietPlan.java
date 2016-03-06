package TopCoder;

import java.util.Map;
import java.util.TreeMap;

/*
 * SRM 372 Div1
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=8222
 */

public class SRM372DietPlan {
	public static void main(String[] args) {
		System.out.println(chooseDinner("ABCD", "AB", "C"));
		System.out.println(chooseDinner("ABEDCS", "", ""));
		System.out.println(chooseDinner("EDSMB", "MSD", "A"));
		System.out.println(chooseDinner("", "", ""));
		System.out.println(chooseDinner("IWANTSODER", "SOW", "RAT"));
	}
	public static String chooseDinner(String diet, String breakfast, String lunch){
		TreeMap<Character,Integer> charCount=new TreeMap<>();
		for (int i = 0; i < diet.length(); i++) {
			char c=diet.charAt(i);
			if(!charCount.containsKey(c))
			{
				charCount.put(c,1);
			}
			else{
				charCount.put(c,charCount.get(c)+1);
			}
		}
		for (int i = 0; i < breakfast.length(); i++) {
			char c=breakfast.charAt(i);
			if(charCount.containsKey(c))
			{
				if(charCount.get(c)==0)
					return "CHEATER";
				else
					charCount.put(c,charCount.get(c)-1);
			}
			else{
				return "CHEATER";
			}
		}
		for (int i = 0; i < lunch.length(); i++) {
			char c=lunch.charAt(i);
			if(charCount.containsKey(c))
			{
				if(charCount.get(c)==0)
					return "CHEATER";
				else
					charCount.put(c,charCount.get(c)-1);
			}
			else{
				return "CHEATER";
			}
		}
		StringBuilder sb=new StringBuilder();
		for (Map.Entry<Character,Integer> entry : charCount.entrySet())
		{
			Character key=entry.getKey();
			Integer count=entry.getValue();
			for (int i = 0; i < count; i++) {
				sb.append(key);
			}
		}
		return sb.toString();
	}
}
