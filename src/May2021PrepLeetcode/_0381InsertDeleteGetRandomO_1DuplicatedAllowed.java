package May2021PrepLeetcode;

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

		/** Initialize your data structure here. */
		public RandomizedCollection() {
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did not
		 * already contain the specified element.
		 */
		public boolean insert(int val) {

		}

		/**
		 * Removes a value from the collection. Returns true if the collection contained
		 * the specified element.
		 */
		public boolean remove(int val) {

		}

		/** Get a random element from the collection. */
		public int getRandom() {

		}
	}

}
