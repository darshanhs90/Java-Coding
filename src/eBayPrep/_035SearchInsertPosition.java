package eBayPrep;

public class _035SearchInsertPosition {

	public static void main(String[] args) {
		System.out.println("5->"+(searchInsert(new int[]{1,3,5,6},5)));
		System.out.println();
		System.out.println("2->"+(searchInsert(new int[]{1,3,5,6},2)));
		System.out.println();
		System.out.println("7->"+(searchInsert(new int[]{1,3,5,6},7)));
		System.out.println();
		System.out.println("0->"+(searchInsert(new int[]{1,3,5,6},0)));
	}

	public static int searchInsert(int[] nums, int target) {
		int startPosition=findStart(nums,0,nums.length-1,target);
		return startPosition;
	}

	private static int findStart(int[] arr, int low, int high, int target) {
		if(low>high){
			//System.out.println("low->"+low+"/high->"+high);
			return low;
		}
		int mid=(low+high)/2;
		if(arr[mid]==target &&(mid==0 || arr[mid-1]!=target))
			return mid;
		else if(arr[mid]<target)
		{
			return findStart(arr, mid+1, high, target);
		}
		return 
				findStart(arr, low, mid-1, target);
	}

}
