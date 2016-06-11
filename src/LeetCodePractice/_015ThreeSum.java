package LeetCodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _015ThreeSum {

	public static void main(String[] args) {

	}
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		HashSet<String> set=new HashSet<>();
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			int left=0;
			int right=nums.length-1;
			int centreVal=nums[i];
			while(left<right)
			{
				int leftVal=nums[left];
				int rightVal=nums[right];
				if(left==i){
					left++;
					continue;
				}else if(right==i)
				{
					right--;
					continue;
				}
				int sum=nums[i]+nums[left]+nums[right];
				if(sum==0)
				{
					int[] arr=new int[]{nums[i],nums[left],nums[right]};
					Arrays.sort(arr);
					String str=arr[0]+"/"+arr[1]+"/"+arr[2];
					if(!set.contains(str)){
						set.add(str);
						List<Integer> lst=new ArrayList<>();
						lst.add(arr[0]);lst.add(arr[1]);lst.add(arr[2]);
						list.add(lst);
					}
					break;
				}
				else if(sum<0)
				{
					left++;
				}
				else{
					right--;
				}
			}
		}
		return list;
	}
}
