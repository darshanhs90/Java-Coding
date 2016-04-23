package yelpInterview;

import java.util.HashMap;
import java.util.Map;

public class _Array02MajorityElement {
	public static void main(String a[]){
		int inputArray[] = {3,3,4,2,4,4,2,4,4};
		System.out.println(findMajorityElement(inputArray));
	}

	private static String findMajorityElement(int[] inputArray) {
		HashMap<Integer, Integer> elementCount=new HashMap<>();
		for (int i = 0; i < inputArray.length; i++) {
			if(elementCount.containsKey(inputArray[i]))
			{
				elementCount.put(inputArray[i], elementCount.get(inputArray[i])+1);
			}
			else
				elementCount.put(inputArray[i], 1);
		}
		Map<Integer, Integer> map =elementCount;
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			if(entry.getValue()>inputArray.length/2)
				return entry.getKey()+"";
		}
		return "NONE";
	}



}

