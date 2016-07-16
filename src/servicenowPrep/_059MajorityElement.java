package servicenowPrep;

import java.util.HashMap;

public class _059MajorityElement
{

	public static void main(String[] args) {
		int inputArray[]=new int[] {1, 4,7,4,8,4,10,4,18};
		System.out.println(findMajorityElement(inputArray));
	}
	static HashMap<Integer, Integer> elementCountMap=new HashMap<>();
	private static int findMajorityElement(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			if(elementCountMap.containsKey(inputArray[i]))
			{
				elementCountMap.put(inputArray[i], elementCountMap.get(inputArray[i])+1);
			}
			else{
				elementCountMap.put(inputArray[i],1);
			}
		}
		Object[] keyArr=elementCountMap.keySet().toArray();
		int maxCount=0,element=0;
		for (int i = 0; i < keyArr.length; i++) {
			if(elementCountMap.get(keyArr[i])>maxCount)
			{
				maxCount=elementCountMap.get(keyArr[i]);
				element=(int) keyArr[i];
			}
		}
		return element;
	}

	
}