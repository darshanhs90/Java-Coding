package Nov2020_UberPrep;

import java.util.HashMap;
import java.util.Random;

public class _048RandomPickIndex {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 3, 3 };
		Solution solution = new Solution(nums);

		// pick(3) should return either index 2, 3, or 4 randomly. Each index should
		// have equal probability of returning.
		System.out.println(solution.pick(3));

		// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
		System.out.println(solution.pick(1));
	}

	static class Solution {
		HashMap<Integer, HashMap<Integer, Integer>> map;
		Random random;

		public Solution(int[] nums) {
			map = new HashMap<Integer, HashMap<Integer, Integer>>();
			random = new Random();
			for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(nums[i])) {
					HashMap<Integer, Integer> mapNew = map.get(nums[i]);
					mapNew.put(mapNew.size(), i);
					map.put(nums[i], mapNew);
				} else {
					HashMap<Integer, Integer> mapNew = new HashMap<Integer, Integer>();
					mapNew.put(mapNew.size(), i);
					map.put(nums[i], mapNew);
				}
			}
		}

		public int pick(int target) {
			if (map.get(target).size() > 0) {
				int randIndex = random.nextInt(map.get(target).size());
				return map.get(target).get(randIndex);
			} else {
				return map.get(target).get(0);
			}
		}
	}

}
