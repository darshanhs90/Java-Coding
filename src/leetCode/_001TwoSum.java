package leetCode;

/*
 * Link : https://leetcode.com/problems/two-sum/
*/
import java.util.Arrays;
public class _001TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int startIndex=0,endIndex=nums.length-1;
		int mainArray[]=Arrays.copyOf(nums,nums.length);
		Arrays.sort(nums);
		while(true){

			if(nums[startIndex]+nums[endIndex]==target)
				break;
			if(nums[startIndex]+nums[endIndex]>target)
			{
				endIndex--;
			}
			else if(nums[startIndex]+nums[endIndex]<target)
			{
				startIndex++;
			}
		}
		boolean startIndexFlag=true,endIndexFlag=true;

		for (int i = 0; i < nums.length; i++) {
			if(nums[startIndex]==mainArray[i] && startIndexFlag){
				startIndex=i;
				startIndexFlag=false;
			}
			else if(nums[endIndex]==mainArray[i] && endIndexFlag){
				endIndex=i;
				endIndexFlag=false;
			}
		}
		int output[]=new int[]{startIndex+1,endIndex+1};
		Arrays.sort(output);
		return output;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{3,2,4},6)));
	}
}