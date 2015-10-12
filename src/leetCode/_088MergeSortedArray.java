package leetCode;

/*
 * Link : https://leetcode.com/problems/merge-sorted-array/
 */

public class _088MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int mLastIndex=m-1;
		int nLastIndex=n-1;
		int arrayLastIndex=nums1.length-1;
		while((mLastIndex+1)>0 && (nLastIndex+1)>0)
		{
			if(nums1[mLastIndex]>nums2[nLastIndex])
			{
				nums1[arrayLastIndex]=nums1[mLastIndex];
				arrayLastIndex--;
				mLastIndex--;
			}
			else{
				nums1[arrayLastIndex]=nums2[nLastIndex];
				arrayLastIndex--;
				nLastIndex--;
			}	
		}
		while((nLastIndex+1)>0)
		{
			nums1[arrayLastIndex]=nums2[nLastIndex];
			arrayLastIndex--;
			nLastIndex--;
		}
	}

	public static void main(String[] args) {
		
		merge(new int[]{2,0},1,new int[]{1},1);
		
	}
}