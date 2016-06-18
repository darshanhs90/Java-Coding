package LeetCodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _090Subsets2 {

	public static void main(String[] args) {
		List<List<Integer>> op=subsetsWithDup(new int[]{1,2,2});
		for (int i = 0; i < op.size(); i++) {
			System.out.println(Arrays.toString(op.get(i).toArray()));
		}
	}

	public  static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> outputList=new ArrayList<>();
		Arrays.sort(nums);
		Set<String> set=new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> tempList=new ArrayList<>();
			for (int j = 0; j < outputList.size(); j++) {
				tempList.add(new ArrayList<>(outputList.get(j)));
			}
			for (int j = 0; j < tempList.size(); j++) {
				List<Integer> list=tempList.get(j);
				list.add(nums[i]);
			}
			List<Integer> singleElementList=new ArrayList<>();
			singleElementList.add(nums[i]);
			String st=Arrays.toString(singleElementList.toArray());
			tempList.add(singleElementList);
			for (int j = 0; j < tempList.size(); j++) {
				List<Integer> ls=tempList.get(j);
				if(!set.contains(Arrays.toString(ls.toArray()))){
					set.add(Arrays.toString(ls.toArray()));
					outputList.add(ls);
				}
			}

		}
		outputList.add(new ArrayList<>());
		return outputList;
	}

}

