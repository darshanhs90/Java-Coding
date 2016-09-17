package LeetCodePerformancePractice;

import java.util.HashMap;

public class _299BullsAndCows {
	public static void main(String[] args) {
		System.out.println(getHint("112332", "011224"));
	}
	public static String getHint(String secret, String guess) {
		HashMap<Character, Integer> elementCount1=new HashMap<>();
		HashMap<Character, Integer> elementCount2=new HashMap<>();

		int bullCount=0,cowCount=0;
		for (int i = 0; i < secret.length(); i++) {
			char c1=secret.charAt(i);
			char c2=guess.charAt(i);
			if(c1==c2)
			{
				bullCount++;
			}
			else{
				if(elementCount1.containsKey(c1))
				{
					elementCount1.put(c1,elementCount1.get(c1)+1);
				}
				else{
					elementCount1.put(c1, 1);
				}
				if(elementCount2.containsKey(c2))
				{
					elementCount2.put(c2,elementCount2.get(c2)+1);
				}
				else{
					elementCount2.put(c2, 1);
				}
			}
		}
		Object[] arr=elementCount1.keySet().toArray();
		for (int i = 0; i < arr.length; i++) {
			if(elementCount2.containsKey(arr[i]))
			{
				cowCount+=Math.min(elementCount1.get(arr[i]), elementCount2.get(arr[i]));
			}
		}
		return bullCount+"A"+cowCount+"B";
	}

}
