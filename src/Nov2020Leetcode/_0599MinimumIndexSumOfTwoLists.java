package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
		List<String> outputList = new ArrayList<String>();
		int minIndexVal = Integer.MAX_VALUE;
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}

		for (int i = 0; i < list2.length; i++) {
			if (map.containsKey(list2[i])) {
				if (i + map.get(list2[i]) < minIndexVal) {
					outputList = new ArrayList<String>();
					outputList.add(list2[i]);
					minIndexVal = i + map.get(list2[i]);
				} else if (i + map.get(list2[i]) == minIndexVal) {
					outputList.add(list2[i]);
				}
			}
		}

		String[] output = new String[outputList.size()];
		for (int i = 0; i < outputList.size(); i++) {
			output[i] = outputList.get(i);
		}
		return output;
	}
}
