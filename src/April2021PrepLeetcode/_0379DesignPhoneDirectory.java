package April2021PrepLeetcode;

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
		int maxNumbers, currNumber;
		HashSet<Integer> releasedNumbers;

		/**
		 * Initialize your data structure here
		 * 
		 * @param maxNumbers - The maximum numbers that can be stored in the phone
		 *                   directory.
		 */
		public PhoneDirectory(int maxNumbers) {
			this.maxNumbers = maxNumbers;
			currNumber = 0;
			this.releasedNumbers = new HashSet<Integer>();
		}

		/**
		 * Provide a number which is not assigned to anyone.
		 * 
		 * @return - Return an available number. Return -1 if none is available.
		 */
		public int get() {
			if (currNumber < maxNumbers) {
				return currNumber++;
			} else if (!releasedNumbers.isEmpty()) {
				int number = releasedNumbers.iterator().next();
				releasedNumbers.remove(number);
				return number;
			}
			return -1;
		}

		/** Check if a number is available or not. */
		public boolean check(int number) {
			if (number >= currNumber && number < maxNumbers)
				return true;
			else if (releasedNumbers.contains(number))
				return true;
			return false;
		}

		/** Recycle or release a number. */
		public void release(int number) {
			if (number >= currNumber)
				return;
			if (!releasedNumbers.contains(number))
				releasedNumbers.add(number);
		}
	}

}
