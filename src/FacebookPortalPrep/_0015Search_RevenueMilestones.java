package FacebookPortalPrep;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

public class _0015Search_RevenueMilestones {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				getMilestoneDays(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, new int[] { 100, 200, 500 })));
	}

	public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
		// Write your code here
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int currSum = 0;
		for (int i = 0; i < revenues.length; i++) {
			currSum += revenues[i];
			map.put(currSum, i + 1);
		}

		int[] output = new int[milestones.length];
		for (int i = 0; i < milestones.length; i++) {
			Entry<Integer, Integer> floorEntry = map.floorEntry(milestones[i]);
			Entry<Integer, Integer> ceilEntry = map.ceilingEntry(milestones[i]);
			if (floorEntry == null) {
				output[i] = -1;
			} else {
				if (milestones[i] == floorEntry.getKey()) {
					output[i] = floorEntry.getValue();
				} else {
					output[i] = ceilEntry == null ? -1 : ceilEntry.getValue();
				}
			}
		}
		return output;
	}
}
