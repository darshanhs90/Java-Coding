package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0442FindAllDuplicatesinAnArray {

	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
	}

	public static List<Integer> findDuplicates(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		List<Integer> output = new ArrayList<Integer>();
		for (int num : nums) {
			if (set.contains(num)) {
				output.add(num);
			}
			set.add(num);
		}
		return output;
	}

}
