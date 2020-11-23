package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0219ContainsDuplicateII {

	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
		System.out.println(containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
		System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				list = map.get(nums[i]);
				for (int j = 0; j < list.size(); j++) {
					if (i - list.get(j) <= k)
						return true;
				}
				list.add(i);

			} else {
				list = new ArrayList<Integer>();
				list.add(i);
			}
			map.put(nums[i], list);
		}
		return false;
	}
}
