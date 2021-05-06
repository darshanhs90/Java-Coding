package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class _0381InsertDeleteGetRandomO_1DuplicatedAllowed {

	public static void main(String[] args) {
		// Init an empty collection.
		RandomizedCollection collection = new RandomizedCollection();

		// Inserts 1 to the collection. Returns true as the collection did not contain
		// 1.
		/*
		 * System.out.println(collection.insert(1));
		 * 
		 * // Inserts another 1 to the collection. Returns false as the collection //
		 * contained 1. Collection now contains [1,1].
		 * System.out.println(collection.insert(1));
		 * 
		 * // Inserts 2 to the collection, returns true. Collection now contains
		 * [1,1,2]. System.out.println(collection.insert(2));
		 * 
		 * // getRandom should return 1 with the probability 2/3, and returns 2 with the
		 * // probability 1/3. System.out.println(collection.getRandom());
		 * 
		 * // Removes 1 from the collection, returns true. Collection now contains
		 * [1,2]. System.out.println(collection.remove(1));
		 * 
		 * // getRandom should return 1 and 2 both equally likely.
		 * System.out.println(collection.getRandom());
		 */

		collection = new RandomizedCollection();

		// Inserts 1 to the collection. Returns true as the collection did not contain
		// 1.
		System.out.println(collection.insert(4));

		// Inserts another 1 to the collection. Returns false as the collection
		// contained 1. Collection now contains [1,1].
		System.out.println(collection.insert(3));

		// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
		System.out.println(collection.insert(4));

		// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
		System.out.println(collection.insert(2));

		// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
		System.out.println(collection.insert(4));

		// Removes 1 from the collection, returns true. Collection now contains [1,2].
		System.out.println(collection.remove(4));

		// Removes 1 from the collection, returns true. Collection now contains [1,2].
		System.out.println(collection.remove(3));

		// Removes 1 from the collection, returns true. Collection now contains [1,2].
		System.out.println(collection.remove(4));

		// Removes 1 from the collection, returns true. Collection now contains [1,2].
		System.out.println(collection.remove(4));
	}

	static class RandomizedCollection {
		HashMap<Integer, HashSet<Integer>> map;
		List<Integer> list;
		Random rand;

		/** Initialize your data structure here. */
		public RandomizedCollection() {
			map = new HashMap<Integer, HashSet<Integer>>();
			list = new ArrayList<Integer>();
			rand = new Random();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did not
		 * already contain the specified element.
		 */
		public boolean insert(int val) {
			boolean out = false;

			if (!map.containsKey(val) || map.get(val).size() == 0)
				out = true;

			if (!map.containsKey(val)) {
				map.put(val, new HashSet<Integer>());
			}
			map.get(val).add(list.size());
			list.add(val);
			return out;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection contained
		 * the specified element.
		 */
		public boolean remove(int val) {
			if (!map.containsKey(val) || map.get(val).size() == 0)
				return false;
			// get last element
			// get its map and update tat

			// get curr element and its map and remove it from map
			// set last elements index

			int remove_idx = map.get(val).iterator().next();
			map.get(val).remove(remove_idx);
			int last = list.get(list.size() - 1);
			list.set(remove_idx, last);
			map.get(last).add(remove_idx);
			map.get(last).remove(list.size() - 1);

			list.remove(list.size() - 1);
			return true;

		}

		/** Get a random element from the collection. */
		public int getRandom() {
			return list.get(rand.nextInt(list.size()));
		}
	}

}
