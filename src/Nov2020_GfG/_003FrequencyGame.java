package Nov2020_GfG;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class _003FrequencyGame {

	public static void main(String[] args) {
		System.out.println(LargButMinFreq(new int[] { 50, 2, 2, 5, 1 }, 5));
	}

	// Function to find largest number with minimum frequency
	public static int LargButMinFreq(int arr[], int n) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		for (int i = 0; i < arr.length; i++) {
			map.compute(arr[i], (k, v) -> v == null ? 1 : v + 1);
		}
		int minFrequency = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minFrequency = Math.min(minFrequency, entry.getValue());
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (minFrequency == entry.getValue())
				return entry.getKey();
		}
		return 0;
	}
}
