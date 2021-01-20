package Dec2020Leetcode;

import java.util.HashMap;

public class _0403FrogJump {

	public static void main(String[] args) {
		System.out.println(canCross(new int[] { 0, 1, 3, 5, 6, 8, 12, 17 }));
		System.out.println(canCross(new int[] { 0, 1, 2, 3, 4, 8, 9, 11 }));
	}

	public static boolean canCross(int[] stones) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, HashMap<Integer, Boolean>> memoMap = new HashMap<Integer, HashMap<Integer, Boolean>>();
		for (int i = 0; i < stones.length; i++) {
			map.put(stones[i], i);
		}
		return canCross(0, 0, stones, map, memoMap);
	}

	public static boolean canCross(int index, int jumpSize, int[] stones, HashMap<Integer, Integer> map,
			HashMap<Integer, HashMap<Integer, Boolean>> memoMap) {
		if (index >= stones.length - 1)
			return true;
		boolean val = false;
		if (jumpSize > 0 && map.containsKey(stones[index] + jumpSize)) {
			if (memoMap.containsKey(index) && memoMap.get(index).containsKey(jumpSize))
				val = val || memoMap.get(index).get(jumpSize);
			else {
				val = val || canCross(map.get(stones[index] + jumpSize), jumpSize, stones, map, memoMap);
				HashMap<Integer, Boolean> testMap = new HashMap<Integer, Boolean>();
				testMap.put(jumpSize, val);
				memoMap.put(index, testMap);
			}
		}

		if (jumpSize - 1 > 0 && !val && map.containsKey(stones[index] + jumpSize - 1)) {
			if (memoMap.containsKey(index) && memoMap.get(index).containsKey(jumpSize - 1))
				val = val || memoMap.get(index).get(jumpSize - 1);
			else {
				val = val || canCross(map.get(stones[index] + jumpSize - 1), jumpSize - 1, stones, map, memoMap);
				HashMap<Integer, Boolean> testMap = new HashMap<Integer, Boolean>();
				testMap.put(jumpSize - 1, val);
				memoMap.put(index, testMap);
			}
		}

		if (jumpSize + 1 > 0 && !val && map.containsKey(stones[index] + jumpSize + 1)) {
			if (memoMap.containsKey(index) && memoMap.get(index).containsKey(jumpSize + 1))
				val = val || memoMap.get(index).get(jumpSize + 1);
			else {
				val = val || canCross(map.get(stones[index] + jumpSize + 1), jumpSize + 1, stones, map, memoMap);
				HashMap<Integer, Boolean> testMap = new HashMap<Integer, Boolean>();
				testMap.put(jumpSize + 1, val);
				memoMap.put(index, testMap);
			}
		}
		return val;
	}

}
