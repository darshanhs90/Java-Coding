package LeetCodePerformancePractice;

public class _033SearchSortedRotatedArray {
	public static void main(String[] args) {
		System.out.println(search(new int[]{4,5,6,7,0,1,2},5));
		System.out.println(search(new int[]{1,2,3,4,5,6,7},5));		
		System.out.println(search(new int[]{5,1,3},51));
	}
	public static int search(int[] nums, int target) {
		int left=0,right=nums.length-1;
		while(left<=right)
		{
			int middle=(left+right)/2;
			if(nums[middle]==target)
				return middle;
			if(nums[left]<=nums[middle])
			{
				if(nums[left]<=target && target<nums[middle])
				{
					right=middle-1;
				}
				else
					left=middle+1;
			}
			else{
				if(nums[middle]<target && target <=nums[right])
				{
					left=middle+1;
				}
				else
					right=middle-1;
			}
		}
		return -1;
	}

}

