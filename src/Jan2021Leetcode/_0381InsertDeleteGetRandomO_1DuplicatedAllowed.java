package Jan2021Leetcode;

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
		List<Integer> list;
		HashMap<Integer, HashSet<Integer>> map;
		Random rand;

		/** Initialize your data structure here. */
		public RandomizedCollection() {
			list = new ArrayList<Integer>();
			map = new HashMap<Integer, HashSet<Integer>>();
			rand = new Random();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did not
		 * already contain the specified element.
		 */
		public boolean insert(int val) {
			if (map.containsKey(val)) {
				map.get(val).add(list.size());
				list.add(val);
				return false;
			} else {
				map.put(val, new HashSet<Integer>());
				map.get(val).add(list.size());
				list.add(val);
				return true;
			}
		}

		/**
		 * Removes a value from the collection. Returns true if the collection contained
		 * the specified element.
		 */
		public boolean remove(int val) {
			if (map.containsKey(val) && map.get(val).size() > 0) {
				int valIndex = map.get(val).iterator().next();
				map.get(val).remove(valIndex);
				int lastElementValue = list.get(list.size() - 1);
				list.set(valIndex, lastElementValue);
				map.get(lastElementValue).add(valIndex);	
				map.get(lastElementValue).remove(list.size() - 1);
				list.remove(list.size() - 1);
				return true;
			}
			return false;
		}

		/** Get a random element from the collection. */
		public int getRandom() {
			return list.get(rand.nextInt(list.size()));
		}
	}

}
