package April2021Leetcode;

import java.util.HashSet;

public class _0379DesignPhoneDirectory {

	public static void main(String[] args) {
		// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
		PhoneDirectory directory = new PhoneDirectory(3);

		// It can return any available phone number. Here we assume it returns 0.
		System.out.println(directory.get());

		// Assume it returns 1.
		System.out.println(directory.get());

		// The number 2 is available, so return true.
		System.out.println(directory.check(2));

		// It returns 2, the only number that is left.
		System.out.println(directory.get());

		// The number 2 is no longer available, so return false.
		System.out.println(directory.check(2));

		// Release number 2 back to the pool.
		directory.release(2);

		// Number 2 is available again, return true.
		System.out.println(directory.check(2));
	}

	static class PhoneDirectory {
		int index, maxNumbers;
		HashSet<Integer> releasedNumbers;

		/**
		 * Initialize your data structure here
		 * 
		 * @param maxNumbers - The maximum numbers that can be stored in the phone
		 *                   directory.
		 */
		public PhoneDirectory(int maxNumbers) {
			this.index = 0;
			this.maxNumbers = maxNumbers;
			this.releasedNumbers = new HashSet<Integer>();
		}

		/**
		 * Provide a number which is not assigned to anyone.
		 * 
		 * @return - Return an available number. Return -1 if none is available.
		 */
		public int get() {
			if (index < maxNumbers) {
				return index++;
			} else {
				if (!releasedNumbers.isEmpty()) {
					int newNumber = releasedNumbers.iterator().next();
					releasedNumbers.remove(newNumber);
					return newNumber;
				}
			}
			return -1;
		}

		/** Check if a number is available or not. */
		public boolean check(int number) {
			return releasedNumbers.contains(number) || (number >= index && number < maxNumbers);
		}

		/** Recycle or release a number. */
		public void release(int number) {
			if (number < index)
				releasedNumbers.add(number);
		}
	}

}
