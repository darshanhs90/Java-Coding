package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class _0539MinimumTimeDifference {

	public static void main(String[] args) {
		System.out.println(findMinDifference(new ArrayList<String>(Arrays.asList("23:59", "00:00"))));
		System.out.println(findMinDifference(new ArrayList<String>(Arrays.asList("00:00", "23:59", "00:00"))));
	}

	public static int findMinDifference(List<String> timePoints) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (String str : timePoints) {
			String[] split = str.split(":");
			int h = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			int val = h * 60 + m;
			if (set.contains(val))
				return 0;
			set.add(val);
		}

		System.out.println(set);

		int prev = 0, min = Integer.MAX_VALUE;
		int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;

		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			Integer val = iter.next();
			if (first != Integer.MAX_VALUE) {
				min = Math.min(min, val - prev);
			}
			first = Math.min(first, val);
			last = Math.max(last, val);
			prev = val;
		}
		return Math.min(min, (24 * 60 - last + first));
	}
}
