package April2021PrepLeetcode;

import java.util.HashMap;
import java.util.Map;

public class _1570DotProductOfTwoSparseVectors {
	public static void main(String[] args) {
		SparseVector v1 = new SparseVector(new int[] { 1, 0, 0, 2, 3 });
		SparseVector v2 = new SparseVector(new int[] { 0, 3, 0, 4, 0 });
		System.out.println(v1.dotProduct(v2));
	}

	static class SparseVector {
		HashMap<Integer, Integer> map;

		SparseVector(int[] nums) {
			map = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					map.put(i, nums[i]);
				}
			}
		}

		// Return the dotProduct of two sparse vectors
		public int dotProduct(SparseVector vec) {
			HashMap<Integer, Integer> vecMap = vec.map;
			int out = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (vecMap.containsKey(entry.getKey())) {
					out += entry.getValue() * vecMap.get(entry.getKey());
				}
			}
			return out;
		}
	}
}
