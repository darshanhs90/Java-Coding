package LeetCodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _018FourSum {

	public static void main(String[] args) {
		System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
	}



	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> outputList=new ArrayList<>();
		Set<String> set=new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if(i==j)
					continue;
				int left=0;
				int right=nums.length-1;
				while(left<right)
				{
					if(left==i || left==j){
						left++;
						continue;
					}
					if(right==i || right==j){
						right--;
						continue;
					}
					int sum=nums[left]+nums[right]+nums[i]+nums[j];
					if(sum==target)
					{
						int[] temp=new int[4];
						temp[0]=nums[left];
						temp[1]=nums[right];
						temp[2]=nums[i];
						temp[3]=nums[j];
						Arrays.sort(temp);
						String str=Arrays.toString(temp);
						if(!set.contains(str)){
							List<Integer> list=new ArrayList<>();
							list.add(temp[0]);
							list.add(temp[1]);
							list.add(temp[2]);
							list.add(temp[3]);
							outputList.add(list);
							set.add(str);
						}
						left++;
						right--;
					}
					else if(sum>target)
						right--;
					else
						left++;
				}
			}
		}
		return outputList;
	}
}
