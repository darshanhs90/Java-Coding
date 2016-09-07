package LeetCodePerformancePractice;

public class _035SearchInsertPosition {
	public static void main(String[] args) {
		System.out.println(searchInsert(new int[]{1,3,5,6}, 5));//2
		System.out.println(searchInsert(new int[]{1,3,5,6}, 2));//1
		System.out.println(searchInsert(new int[]{1,3,5,6}, 7));//4
		System.out.println(searchInsert(new int[]{1,3,5,6}, 0));//0
	}
	public static int searchInsert(int[] arr, int target) {
		int left=0,right=arr.length-1;
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(arr[mid]==target)
				return mid;
			else if(arr[mid]<target)
			{
				left=mid+1;
			}
			else{
				right=mid-1;
			}
		}
		return Math.max(left, right);
	}
}

