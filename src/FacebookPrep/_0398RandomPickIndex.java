package FacebookPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class _0398RandomPickIndex {

	public static void main(String[] args) {

	}

	static class Solution {
		HashMap<Integer, List<Integer>> map;
		Random rand;

		public Solution(int[] nums) {
			map = new HashMap<Integer, List<Integer>>();
			for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(nums[i])) {
					map.get(nums[i]).add(i);
				} else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(i);
					map.put(nums[i], list);
				}
			}
			rand = new Random();
		}

		public int pick(int target) {
			List<Integer> list = map.get(target);
			return list.get(rand.nextInt(list.size()));
		}
	}
}
