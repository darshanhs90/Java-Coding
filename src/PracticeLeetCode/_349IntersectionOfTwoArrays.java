package PracticeLeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class _349IntersectionOfTwoArrays {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersection(new int[]{2, 2, 2, 1}, new int[]{2})));
	}
	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set=new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		HashSet<Integer> newSet=new HashSet<>();
		for (int i = 0; i < nums2.length; i++) {
			if(set.contains(nums2[i]))
				newSet.add(nums2[i]);
		}
		
		int[] result=new int[newSet.size()];
		int index=0;
		for(int i : newSet)
		{
			result[index]=i;
			index++;
		}
		return result;
	}
}
