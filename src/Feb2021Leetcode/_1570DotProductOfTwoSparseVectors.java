package Feb2021Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1570DotProductOfTwoSparseVectors {
	public static void main(String[] args) {
		SparseVector v1 = new SparseVector(new int[] { 1, 0, 0, 2, 3 });
		SparseVector v2 = new SparseVector(new int[] { 0, 3, 0, 4, 0 });
		System.out.println(v1.dotProduct(v2));
	}

	static class SparseVector {
		HashMap<Integer, Integer> indexToValueMap;

		SparseVector(int[] nums) {
			indexToValueMap = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					indexToValueMap.put(i, nums[i]);
				}
			}
		}

		// Return the dotProduct of two sparse vectors
		public int dotProduct(SparseVector vec) {
			HashMap<Integer, Integer> vecMap = vec.indexToValueMap;
			int out = 0;
			if (vecMap.size() > indexToValueMap.size()) {

				for (Map.Entry<Integer, Integer> entry : indexToValueMap.entrySet()) {
					if (vecMap.containsKey(entry.getKey())) {
						out += vecMap.get(entry.getKey()) * entry.getValue();
					}
				}
			} else {
				for (Map.Entry<Integer, Integer> entry : vecMap.entrySet()) {
					if (indexToValueMap.containsKey(entry.getKey())) {
						out += indexToValueMap.get(entry.getKey()) * entry.getValue();
					}
				}
			}
			return out;
		}
	}
}
