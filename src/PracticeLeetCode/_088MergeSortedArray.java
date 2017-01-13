package PracticeLeetCode;

import java.util.Arrays;

public class _088MergeSortedArray {
	public static void main(String[] args) {

	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int outputIndex=m+n-1;
		int mIndex=m-1;
		int nIndex=n-1;
		while(mIndex>=0 || nIndex>=0)
		{
			if(mIndex>=0 && nIndex>=0)
			{
				if(nums1[mIndex]>nums2[nIndex])
				{
					nums1[outputIndex]=nums1[mIndex];
					mIndex--;
				}else{
					nums1[outputIndex]=nums2[nIndex];
					nIndex--;		
				}
			}
			else if(mIndex>=0)
			{
				nums1[outputIndex]=nums1[mIndex];
				mIndex--;
			}else
			{
				nums1[outputIndex]=nums2[nIndex];
				nIndex--;	
			}
			outputIndex--;
		}
	}
}
