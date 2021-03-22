package Mar2021Leetcode;

import java.util.HashMap;
import java.util.TreeMap;

public class _0981TimeBasedKeyValueStore {

	public static void main(String[] args) {
		TimeMap kv = new TimeMap();
		kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
		System.out.println(kv.get("foo", 1)); // output "bar"
		System.out.println(kv.get("foo", 3)); // output "bar" since there is no value corresponding to foo at timestamp
												// 3 and
		// timestamp 2, then the only value is at timestamp 1 ie "bar"
		kv.set("foo", "bar2", 4);
		System.out.println(kv.get("foo", 4)); // output "bar2"
		System.out.println(kv.get("foo", 5)); // output "bar2"
	}

	static class TimeMap {

		/** Initialize your data structure here. */
		public TimeMap() {
		}

		public void set(String key, String value, int timestamp) {

		}

		public String get(String key, int timestamp) {
			
		}
	}

}
