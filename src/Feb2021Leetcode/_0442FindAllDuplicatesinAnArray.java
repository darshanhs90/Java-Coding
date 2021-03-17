package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0442FindAllDuplicatesinAnArray {

	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
		System.out.println(findDuplicates(new int[] { 1, 1 }));

	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i])-1;
			
            if (nums[index] < 0) { // seen before
                output.add(Math.abs(nums[i]));
            }
            nums[index] *= -1;
		}
		return output;
	}

}
