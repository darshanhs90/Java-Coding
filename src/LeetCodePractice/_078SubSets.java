package LeetCodePractice;

import java.util.ArrayList;
import java.util.List;

public class _078SubSets {


	public static void main(String[] args) {
		subsets(new int[]{1,2,3});
	}									


	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output=new ArrayList<List<Integer>>();
		
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> temp=new ArrayList<List<Integer>>();
				
			//take al in the result n add that to temp
			for (int j = 0; j < output.size(); j++) {
				temp.add(new ArrayList<Integer>(output.get(j)));
			}
			for (int j = 0; j < temp.size(); j++) {
				List<Integer> a=temp.get(j);
				a.add(nums[i]);
			}
			
			
			List<Integer> singleElement=new ArrayList<>();
			singleElement.add(nums[i]);
			temp.add(singleElement);
			output.addAll(temp);
		}
		output.add(new ArrayList<Integer>());
		return output;
	}
	
}

