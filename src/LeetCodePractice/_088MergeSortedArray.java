package LeetCodePractice;

import java.util.Arrays;

public class _088MergeSortedArray {
					


	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int nums1Pointer=m-1;
		int nums2Pointer=n-1;
		int outputPointer=nums1.length-1;
		while(outputPointer>=0)
		{
			if(nums1Pointer>=0 && nums2Pointer>=0)
			{
				if(nums1[nums1Pointer]>nums2[nums2Pointer])
				{
					nums1[outputPointer]=nums1[nums1Pointer];
					nums1Pointer--;
				}
				else{
					nums1[outputPointer]=nums2[nums2Pointer];
					nums2Pointer--;
				}
			}
			else if(nums1Pointer<0)
			{
				nums1[outputPointer]=nums2[nums2Pointer];
				nums2Pointer--;
			}
			else{
				nums1[outputPointer]=nums1[nums1Pointer];
				nums1Pointer--;
			}
			outputPointer--;
		}
		System.out.println(Arrays.toString(nums1));
		
	}

}

