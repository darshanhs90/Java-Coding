package PracticeLeetCode;

import java.util.Arrays;

public class _088MergeSortedArray {
	public static void main(String[] args) {
		merge(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3);

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = nums1.length - 1;
		int mIndex = m - 1;
		int nIndex = n - 1;
		while(mIndex >= 0 || nIndex >= 0)
		{
			Integer mVal = mIndex >= 0 ? nums1[mIndex] : null;
			Integer nVal = nIndex >= 0 ? nums2[nIndex] : null; 
			if(mVal != null && nVal != null)
			{
				if(mVal > nVal)
				{
					nums1[index] = mVal;
					mIndex--;
				}
				else {
					nums1[index] = nVal;
					nIndex--;
				}				
			}
			else if (mVal != null)
			{
				break;
			}
			else if (nVal != null)
			{			
				nums1[index] = nVal;
				nIndex--;
			}
			index--;
		}
		
		System.out.println(Arrays.toString(nums1));
	}

}
