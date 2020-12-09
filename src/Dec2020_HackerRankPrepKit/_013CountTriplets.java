package Dec2020_HackerRankPrepKit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _013CountTriplets {

	public static void main(String[] args) {
		System.out
				.println(countTriplets(new ArrayList<Long>(Arrays.asList((long) 1, (long) 2, (long) 2, (long) 4)), 2));

		System.out.println(countTriplets(
				new ArrayList<Long>(Arrays.asList((long) 1, (long) 3, (long) 9, (long) 9, (long) 27, (long) 81)), 3));

		System.out.println(countTriplets(
				new ArrayList<Long>(Arrays.asList((long) 1, (long) 5, (long) 5, (long) 25, (long) 125)), 5));
	}

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {
		HashMap<Long, Integer> valueMap = new HashMap<Long, Integer>();
		for (Long val : arr) {
			if (valueMap.containsKey(val)) {
				valueMap.put(val, valueMap.get(val) + 1);
			} else {
				valueMap.put(val, 1);
			}
		}
		long count = 0;
		for (Map.Entry<Long, Integer> entry : valueMap.entrySet()) {
			Long startValue = entry.getKey();
			int startValueCount = entry.getValue();
			if (valueMap.containsKey(startValue * r) && valueMap.containsKey(startValue * r * r)) {
				count += startValueCount * valueMap.get(startValue * r) * valueMap.get(startValue * r * r);
			}
		}

		return count;
	}
}
