package Dec2020Leetcode;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class _0414ThirdMaximumNumber {

	public static void main(String[] args) {
		System.out.println(thirdMax(new int[] { 3, 2, 1 }));
		System.out.println(thirdMax(new int[] { 1, 2 }));
		System.out.println(thirdMax(new int[] { 2, 2, 3, 1 }));
		System.out.println(thirdMax(new int[] { 1, 2, 2, 5, 3, 5 }));
	}

	public static int thirdMax(int[] nums) {
		PriorityQueue<Integer> set = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i])) {
				set.add(nums[i]);
				if (set.size() > 3) {
					set.remove(Collections.min(set));
				}
			}
		}

		if (set.size() == 3) {
			Iterator<Integer> iter = set.iterator();
			int out = iter.next();
			while (iter.hasNext()) {
				out = Math.min(out, iter.next());
			}
			return out;
		}

		Iterator<Integer> iter = set.iterator();
		int out = iter.next();
		while (iter.hasNext()) {
			out = Math.max(out, iter.next());
		}
		return out;
	}

}
