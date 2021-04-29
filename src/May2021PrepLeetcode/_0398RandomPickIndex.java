package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class _0398RandomPickIndex {

	public static void main(String[] args) {

	}

	static class Solution {
		Random rand;
		HashMap<Integer, List<Integer>> map;

		public Solution(int[] nums) {
			rand = new Random();
			map = new HashMap<Integer, List<Integer>>();
			for (int i = 0; i < nums.length; i++) {
				if (!map.containsKey(nums[i])) {
					map.put(nums[i], new ArrayList<Integer>());
				}
				map.get(nums[i]).add(i);
			}
		}

		public int pick(int target) {
			List<Integer> list = map.get(target);
			return list.get(rand.nextInt(list.size()));
		}
	}
}
