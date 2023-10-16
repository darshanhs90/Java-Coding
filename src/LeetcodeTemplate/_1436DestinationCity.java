package LeetcodeTemplate;

import java.util.ArrayList;
import java.util.Arrays;
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

	}
}
