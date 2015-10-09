package leetCode;

import java.util.HashMap;

/*
 * Link : https://leetcode.com/problems/majority-element/
 */

public class _169MajorityElement {
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> elementMap=new HashMap<>();
		int maxElement=0,maxElementCount=-Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int element=nums[i];
			if(elementMap.containsKey(element))
			{	
				elementMap.put(element,elementMap.get(element)+1);
				if(elementMap.get(element)+1>maxElementCount){
					maxElementCount=elementMap.get(element)+1;
					maxElement=element;
				}
			}
			else{
				elementMap.put(element,1);
				if(maxElementCount==-Integer.MIN_VALUE)
				{
					maxElement=element;
					maxElementCount=1;
				}
			}
		}
		return maxElement;
	}
}