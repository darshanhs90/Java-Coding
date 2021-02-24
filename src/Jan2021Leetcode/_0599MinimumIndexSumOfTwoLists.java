package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class _0599MinimumIndexSumOfTwoLists {

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(findRestaurant(new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" },
						new String[] { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" })));

		System.out.println(
				Arrays.toString(findRestaurant(new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" },
						new String[] { "KFC", "Shogun", "Burger King" })));

		System.out.println(
				Arrays.toString(findRestaurant(new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" },
						new String[] { "KFC", "Burger King", "Tapioca Express", "Shogun" })));

		System.out.println(
				Arrays.toString(findRestaurant(new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" },
						new String[] { "KNN", "KFC", "Burger King", "Tapioca Express", "Shogun" })));

		System.out.println(Arrays.toString(findRestaurant(new String[] { "KFC" }, new String[] { "KFC" })));
	}

	public static String[] findRestaurant(String[] list1, String[] list2) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}

		TreeMap<Integer, List<String>> outMap = new TreeMap<Integer, List<String>>();
		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < list2.length; i++) {
			if (map.containsKey(list2[i])) {
				int sum = Math.abs(map.get(list2[i]) + i);
				if (outMap.containsKey(sum)) {
					outMap.get(sum).add(list2[i]);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(list2[i]);
					outMap.put(sum, list);
				}
				minSum = Math.min(minSum, sum);
			}
		}

		List<String> lst = outMap.get(minSum);
		String[] output = new String[lst.size()];
		for (int i = 0; i < output.length; i++) {
			output[i] = lst.get(i);
		}
		return output;
	}

}
