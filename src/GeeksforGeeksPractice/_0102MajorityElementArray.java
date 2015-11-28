package GeeksforGeeksPractice;

import java.util.HashMap;

/*
 * Link : http://www.geeksforgeeks.org/majority-element/
 */
public class _0102MajorityElementArray {
	public static void main(String[] args) {
		int inputArray[]={3 ,3 ,4 ,2 ,4 ,4 ,2, 4,4};
		System.out.println(printMajorityElement(inputArray));
		inputArray=new int[]{3,3,4,2,4,4,2,4};
		System.out.println(printMajorityElement(inputArray));
		
	}

	private static int printMajorityElement(int[] inputArray) {
		HashMap<Integer, Integer> elementMap=new HashMap<>();

		int maxCount=0,maxElement=0;
		for (int i = 0; i < inputArray.length; i++) {
			int element=inputArray[i];
			if(elementMap.containsKey(element))
			{
				int count=elementMap.get(element);
				elementMap.put(element, count+1);
				if(count+1>maxCount){
					maxCount=count;
					maxElement=element;
				}
			}
			else{
				elementMap.put(element, 1);
				if(maxCount==0){
					maxCount=1;
					maxElement=element;
				}
			}
		}
		
		if(maxCount>=inputArray.length/2)
			return maxElement;
		return Integer.MIN_VALUE;
	}




}
