package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class _0380InsertDeleteGetRandomO_1 {

	public static void main(String[] args) {
		RandomizedSet randomizedSet = new RandomizedSet();
		System.out.println(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted
														// successfully.
		System.out.println(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
		System.out.println(randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
		System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
		System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
		System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
		System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set,
	}

	static class RandomizedSet {
		/** Initialize your data structure here. */
		public RandomizedSet() {
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already contain
		 * the specified element.
		 */
		public boolean insert(int val) {
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the specified
		 * element.
		 */
		public boolean remove(int val) {
		
		}

		/** Get a random element from the set. */
		public int getRandom() {
		}
	}

}
