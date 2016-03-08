package TopCoder;

import java.util.Arrays;
import java.util.HashMap;

/*
 * SRM 684 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=14184&rd=16688
 */



public class SRM684Istr {
	public static void main(String[] args) {
		System.out.println(count("aba",1));		
		System.out.println(count("abacaba",0));
		System.out.println(count("abacaba",1));		
		System.out.println(count("abacaba",3));
		System.out.println(count("abc",3));		
		System.out.println(count("wersrsresesrsesrawsdsw",11));
	}
	public static int count(String s, int k){
		HashMap<Character,Integer> elementCount=new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(elementCount.containsKey(c)){
				elementCount.put(c, elementCount.get(c)+1);
			}
			else{
				elementCount.put(c,1);
			}
		}
		Object[] valuesArray=elementCount.values().toArray();
		int value=0;
		for (int i = 0; i < k; i++) {
			Arrays.sort(valuesArray);
			valuesArray[valuesArray.length-1]=(int)valuesArray[valuesArray.length-1]-1;
		}
		for (int i = 0; i < valuesArray.length; i++) {
			value+=(int)valuesArray[i]*(int)valuesArray[i];
		}
		return value;
	}
}
