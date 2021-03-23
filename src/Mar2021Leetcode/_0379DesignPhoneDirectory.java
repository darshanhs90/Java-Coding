package Mar2021Leetcode;

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
		HashSet<Integer> usedNumbers, freeNumbers;
		int index, maxNumbers;

		/**
		 * Initialize your data structure here
		 * 
		 * @param maxNumbers - The maximum numbers that can be stored in the phone
		 *                   directory.
		 */
		public PhoneDirectory(int maxNumbers) {
			index = 0;
			this.maxNumbers = maxNumbers;
			this.usedNumbers = new HashSet<Integer>();
			this.freeNumbers = new HashSet<Integer>();
		}

		/**
		 * Provide a number which is not assigned to anyone.
		 * 
		 * @return - Return an available number. Return -1 if none is available.
		 */
		public int get() {
			if (index == maxNumbers && freeNumbers.isEmpty())
				return -1;

			if (index == maxNumbers) {
				int number = freeNumbers.iterator().next();
				freeNumbers.remove(number);
				usedNumbers.add(number);
				return number;
			} else {
				usedNumbers.add(index);
				index++;
				return index - 1;
			}
		}

		/** Check if a number is available or not. */
		public boolean check(int number) {
			if (index == maxNumbers) {
				return freeNumbers.contains(number);
			} else {
				return number >= index && number < maxNumbers;
			}
		}

		/** Recycle or release a number. */
		public void release(int number) {
			usedNumbers.remove(number);
			freeNumbers.add(number);
		}
	}

}
