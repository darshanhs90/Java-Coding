package Feb2021Leetcode;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class _0362DesignHitCounter {

	public static void main(String[] args) {
		HitCounter counter = new HitCounter();

		// hit at timestamp 1.
		counter.hit(1);

		// hit at timestamp 2.
		counter.hit(2);

		// hit at timestamp 3.
		counter.hit(3);

		// get hits at timestamp 4, should return 3.
		System.out.println(counter.getHits(4));

		// hit at timestamp 300.
		counter.hit(300);

		// get hits at timestamp 300, should return 4.
		System.out.println(counter.getHits(300));

		// get hits at timestamp 301, should return 3.
		System.out.println(counter.getHits(301));

	}

	static class HitCounter {
		TreeMap<Integer, Integer> map;

		/** Initialize your data structure here. */
		public HitCounter() {
			map = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		}

		/**
		 * Record a hit.
		 * 
		 * @param timestamp - The current timestamp (in seconds granularity).
		 */
		public void hit(int timestamp) {
			map.compute(timestamp, (k, v) -> v == null ? 1 : v + 1);
		}

		/**
		 * Return the number of hits in the past 5 minutes.
		 * 
		 * @param timestamp - The current timestamp (in seconds granularity).
		 */
		public int getHits(int timestamp) {
			int count = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (timestamp - 300 < entry.getKey() && entry.getKey() <= timestamp) {
					count += entry.getValue();
				} else {
					return count;
				}
			}
			return count;
		}
	}

}
