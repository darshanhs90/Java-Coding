package LeetCodePerformancePractice;

public class _075SortColors {
	public static void main(String[] args) {
		sortColors(new int[]{1,2,0,3,1,0,0,0,0,1,1,2,1,2});
	}
	public static void sortColors(int[] nums) {
		int noOfZeros=0,noOfOnes=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0)noOfZeros++;
			else if(nums[i]==1)noOfOnes++;
		}
		for (int i = 0; i < nums.length; i++) {
			if(noOfZeros>0)
			{
				nums[i]=0;
				noOfZeros--;
			}
			else if(noOfOnes>0)
			{
				nums[i]=1;
				noOfOnes--;
			}
			else
				nums[i]=2;
		}		
	}
}
