package Nov2020_GoogPrep;

import java.util.HashMap;

public class _068LoggerRateLimiter {

	public static void main(String[] args) {
		Logger logger = new Logger();

		// logging string "foo" at timestamp 1
		System.out.println(logger.shouldPrintMessage(1, "foo")); // returns true;

		// logging string "bar" at timestamp 2
		System.out.println(logger.shouldPrintMessage(2, "bar")); // returns true;

		// logging string "foo" at timestamp 3
		System.out.println(logger.shouldPrintMessage(3, "foo")); // returns false;

		// logging string "bar" at timestamp 8
		System.out.println(logger.shouldPrintMessage(8, "bar")); // returns false;

		// logging string "foo" at timestamp 10
		System.out.println(logger.shouldPrintMessage(10, "foo")); // returns false;

		// logging string "foo" at timestamp 11
		System.out.println(logger.shouldPrintMessage(11, "foo")); // returns true;
	}

	static class Logger {
		HashMap<String, Integer> map;

		/** Initialize your data structure here. */
		public Logger() {
			map = new HashMap<String, Integer>();
		}

		/**
		 * Returns true if the message should be printed in the given timestamp,
		 * otherwise returns false. If this method returns false, the message will not
		 * be printed. The timestamp is in seconds granularity.
		 */
		public boolean shouldPrintMessage(int timestamp, String message) {
			if (map.containsKey(message)) {
				int currTimeStamp = map.get(message);
				if (-currTimeStamp + timestamp >= 10) {
					map.put(message, timestamp);
					return true;
				}
			} else {
				map.put(message, timestamp);
				return true;
			}
			return false;
		}
	}

}
