package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class _0381InsertDeleteGetRandomO_1DuplicatedAllowed {

	public static void main(String[] args) {
		// Init an empty collection.
		RandomizedCollection collection = new RandomizedCollection();

		// Inserts 1 to the collection. Returns true as the collection did not contain
		// 1.
		System.out.println(collection.insert(1));

		// Inserts another 1 to the collection. Returns false as the collection
		// contained 1. Collection now contains [1,1].
		System.out.println(collection.insert(1));

		// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
		System.out.println(collection.insert(2));

		// getRandom should return 1 with the probability 2/3, and returns 2 with the
		// probability 1/3.
		System.out.println(collection.getRandom());

		// Removes 1 from the collection, returns true. Collection now contains [1,2].
		System.out.println(collection.remove(1));

		// getRandom should return 1 and 2 both equally likely.
		System.out.println(collection.getRandom());
	}

	static class RandomizedCollection {
		HashMap<Integer, Integer> map;
		List<Integer> list;
		Random random;

		/** Initialize your data structure here. */
		public RandomizedCollection() {
			map = new HashMap<Integer, Integer>();
			list = new ArrayList<Integer>();
			random = new Random();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did not
		 * already contain the specified element.
		 */
		public boolean insert(int val) {
			if (map.containsKey(val) && map.get(val) > 0) {
				map.computeIfPresent(val, (k, v) -> v + 1);
				list.add(val);
				return false;
			}
			map.put(val, 1);
			list.add(val);
			return true;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection contained
		 * the specified element.
		 */
		public boolean remove(int val) {
			if (map.containsKey(val) && map.get(val) > 0) {
				map.computeIfPresent(val, (k, v) -> v - 1);
				list.remove(Integer.valueOf(val));
				return true;
			}
			return false;
		}

		/** Get a random element from the collection. */
		public int getRandom() {
			return list.get(random.nextInt(list.size()));
		}
	}

}
