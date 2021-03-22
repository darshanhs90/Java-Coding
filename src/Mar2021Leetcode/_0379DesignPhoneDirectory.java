package Mar2021Leetcode;

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
		
	}

}
