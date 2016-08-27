package LeetCodePerformancePractice;

public class _026RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,2}));
	}
	public static int removeDuplicates(int[] nums) {
		if(nums==null||nums.length==0||nums.length==1)
			return nums==null?0:nums.length;
		int number=nums[0];
		int count=1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]!=number)
			{
				nums[count]=nums[i];
				number=nums[count];
				count++;
			}
		}
		return count;
	}
	public static int findOddCount(int[] arr,int pos)
	{	
		if(pos>=arr.length)return 0;
		int count=0;
		if(arr[pos]%2!=0)
			count=1;
		return count+findOddCount(arr, pos+1);
	}




}

