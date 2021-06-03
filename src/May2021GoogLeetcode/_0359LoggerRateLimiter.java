package May2021GoogLeetcode;

import java.util.HashMap;

public class _0359LoggerRateLimiter {

	public static void main(String[] args) {
		Logger logger = new Logger();
		logger.shouldPrintMessage(1, "foo"); // return true, next allowed timestamp for "foo" is 1 + 10 = 11
		logger.shouldPrintMessage(2, "bar"); // return true, next allowed timestamp for "bar" is 2 + 10 = 12
		logger.shouldPrintMessage(3, "foo"); // 3 < 11, return false
		logger.shouldPrintMessage(8, "bar"); // 8 < 12, return false
		logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
		logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is
												// 11 + 10 = 21
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
			if (!map.containsKey(message)) {
				map.put(message, timestamp);
				return true;
			}

			if (timestamp - map.get(message) >= 10) {
				map.put(message, timestamp);
				return true;
			}
			return false;
		}
	}

}
