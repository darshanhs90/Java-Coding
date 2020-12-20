package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class _042InsertDeleteGetRandomO_1DuplicatesAllowed {

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
		HashMap<Integer, Set<Integer>> map;
		List<Integer> list;
		Random random;

		/** Initialize your data structure here. */
		public RandomizedCollection() {
			map = new HashMap<Integer, Set<Integer>>();
			list = new ArrayList<Integer>();
			random = new Random();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did not
		 * already contain the specified element.
		 */
		public boolean insert(int val) {
			list.add(val);
			if (map.containsKey(val)) {
				map.get(val).add(list.size() - 1);
				return false;
			} else {
				Set<Integer> set = new LinkedHashSet<Integer>();
				set.add(list.size() - 1);
				map.put(val, set);
				return true;
			}
		}

		/**
		 * Removes a value from the collection. Returns true if the collection contained
		 * the specified element.
		 */
		public boolean remove(int val) {
			if (map.containsKey(val) && map.get(val).size() > 0) {
				int index = map.get(val).iterator().next();
				map.get(val).remove(index);
				int last = list.get(list.size() - 1);
				list.set(index, last);
				map.get(last).add(index);
				map.get(last).remove(list.size() - 1);
				list.remove(list.size() - 1);
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
