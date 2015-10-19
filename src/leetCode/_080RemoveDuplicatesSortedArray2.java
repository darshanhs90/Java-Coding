package leetCode;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Link : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */

public class _080RemoveDuplicatesSortedArray2 {
	public static int removeDuplicates(int[] nums) {
		HashMap<Integer, Integer> elementCount=new HashMap<>();
		int index=-1,count=0;
		for (int i = 0; i < nums.length; i++) {
			if(!elementCount.containsKey(nums[i]))
			{
				count++;
				elementCount.put(nums[i],1);
				if(index!=-1){
					nums[index]=nums[i];
					index++;
				}
			}
			else{
				if(elementCount.get(nums[i])<2){
					elementCount.put(nums[i],2);
					count++;
					if(index!=-1){
						nums[index]=nums[i];
						index++;
					}
				}
				else{
					if(index==-1)
						index=i;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
		return count;
	}

	public static void main(String[] args) {
		int inputArray[]=new int[]{1,1,1,2,2,3};
		System.out.println(removeDuplicates(inputArray));
		System.out.println(Arrays.toString(inputArray));
	}
}