package FacebookPrep;

public class _0004MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(findMedianSortedArrays(new int[] { 0, 0 }, new int[] { 0, 0 }));
		System.out.println(findMedianSortedArrays(new int[] {}, new int[] { 1 }));
		System.out.println(findMedianSortedArrays(new int[] { 2 }, new int[] {}));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int sumLength = len1 + len2;
		int index = 0;
		boolean hasTwoMedian = false;
		int leftIndexLimit = 0, rightIndexLimit = 0, left = 0, right = 0;
		if (sumLength % 2 == 0) {
			leftIndexLimit = sumLength/2-1;
			rightIndexLimit = sumLength/2;
			hasTwoMedian = true;
		} else {
			leftIndexLimit = sumLength/2;
			rightIndexLimit = sumLength/2;
		}
		
		int leftVal = 0,rightVal = 0;
		while(index<sumLength)
		{
			int val = 0;
			if(left < len1 && right < len2)
			{
				if(nums1[left]<nums2[right])
				{
					val = nums1[left];
					left++;
				}
				else {
					val = nums2[right];
					right++;
				}
			}
			else if(left < len1)
			{
				val = nums1[left];
				left++;
			}
			else if(right < len2)
			{
				val = nums2[right];
				right++;
			}
			
			if(index == leftIndexLimit)
			{
				leftVal = val;
			}
			else if(index == rightIndexLimit)
			{
				rightVal = val;
				break;
			}
			index++;
		}
		return hasTwoMedian ? (leftVal+rightVal)/(double)2 : leftVal;
	}

}
