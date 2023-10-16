package Oct2023Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _1436DestinationCity {
	public static void main(String[] args) {
		System.out.println(destCity(
				new ArrayList<List<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList("London", "New York")),
						new ArrayList<String>(Arrays.asList("New York", "Lima")),
						new ArrayList<String>(Arrays.asList("Lima", "Sao Paulo"))))));

		System.out.println(
				destCity(new ArrayList<List<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList("B", "C")),
						new ArrayList<String>(Arrays.asList("D", "B")),
						new ArrayList<String>(Arrays.asList("C", "A"))))));

		System.out.println(
				destCity(new ArrayList<List<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList("A", "Z"))))));
	}

	public static String destCity(List<List<String>> paths) {
		HashSet<String> sources = new HashSet<String>();
		HashSet<String> allPlaces = new HashSet<String>();
		for (int i = 0; i < paths.size(); i++) {
			String src = paths.get(i).get(0);
			String dst = paths.get(i).get(1);
			sources.add(src);
			allPlaces.add(src);
			allPlaces.add(dst);
		}
		for (String str : allPlaces) {
			if (!sources.contains(str))
				return str;
		}
		return "";
	}
}
