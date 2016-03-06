package TopCoder;

import java.util.Map;
import java.util.TreeMap;

/*
 * SRM 146 Div1
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1589
 */



public class SRM146YahtzeeScore {
	public static void main(String[] args) {
		System.out.println(maxPoints(new int[]{2, 2, 3, 5, 4}));
		System.out.println(maxPoints(new int[]{6, 4, 1, 1, 3}));
		System.out.println(maxPoints(new int[]{5, 3, 5, 3, 3}));
		System.out.println(maxPoints(new int[]{5, 4, 3, 2, 8}));
	}
	public static int maxPoints(int[] toss){
		TreeMap<Integer,Integer> elementCount=new TreeMap<>();
		for (int i = 0; i < toss.length; i++) {
			if(!elementCount.containsKey(toss[i]))
			{
				elementCount.put(toss[i], 1);
			}
			else{
				elementCount.put(toss[i], elementCount.get(toss[i])+1);
			}
		}
		int maxValue=0;
		for (Map.Entry<Integer,Integer> entry : elementCount.entrySet())
		{
			int key=entry.getKey();
			int value=entry.getValue();
			if(key*value>maxValue)
			{
				maxValue=key*value;
			}
		}
		return maxValue;
	}
}
