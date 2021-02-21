package DropboxPrep;

import java.util.TreeSet;

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

		/**
		 * Initialize your data structure here
		 * 
		 * @param maxNumbers - The maximum numbers that can be stored in the phone
		 *                   directory.
		 */
		int currIndex = 0;
		int maxNumbers;
		TreeSet<Integer> unusedNumbers;

		public PhoneDirectory(int maxNumbers) {
			this.currIndex = 0;
			this.maxNumbers = maxNumbers;
			this.unusedNumbers = new TreeSet<Integer>();
		}

		/**
		 * Provide a number which is not assigned to anyone.
		 * 
		 * @return - Return an available number. Return -1 if none is available.
		 */
		public int get() {
			if (currIndex >= maxNumbers && this.unusedNumbers.isEmpty())
				return -1;
			else if (currIndex >= maxNumbers) {
				return this.unusedNumbers.pollFirst();
			} else {
				int curr = currIndex;
				currIndex++;
				return curr;
			}
		}

		/** Check if a number is available or not. */
		public boolean check(int number) {
			return currIndex <= number || unusedNumbers.contains(number);
		}

		/** Recycle or release a number. */
		public void release(int number) {
			if (currIndex > number) {
				unusedNumbers.add(number);
			}
		}
	}

}
