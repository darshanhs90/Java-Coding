package PracticeLeetCode;


import java.util.HashSet;
import java.util.Set;

public class _026RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,2,3}));
	}
	public static int removeDuplicates(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		int index=0;
		Set<Integer> set=new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if(!set.contains(nums[i]))
			{
				nums[index]=nums[i];
				index++;
				set.add(nums[i]);
			}
		}
		return index;
	}

}

