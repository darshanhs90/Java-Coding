package FacebookPortalPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class _0020Sorting_CountingTriangles {

	public static void main(String[] args) {
		System.out.println(countDistinctTriangles(
				new ArrayList<Sides>(Arrays.asList(new Sides(2, 2, 3), new Sides(3, 2, 2), new Sides(2, 5, 6)))));

		System.out.println(countDistinctTriangles(new ArrayList<Sides>(
				Arrays.asList(new Sides(8, 4, 6), new Sides(100, 101, 102), new Sides(84, 93, 173)))));

		System.out.println(
				countDistinctTriangles(new ArrayList<Sides>(Arrays.asList(new Sides(5, 8, 9), new Sides(5, 9, 8)))));
	}

	static class Sides {
		int a;
		int b;
		int c;

		Sides(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static int countDistinctTriangles(ArrayList<Sides> arr) {
		// Write your code here
		HashSet<String> set = new HashSet<String>();
		for (Sides side : arr) {

			List<Integer> list = new ArrayList<Integer>();
			list.add(side.a);
			list.add(side.b);
			list.add(side.c);
			Collections.sort(list);

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i) + "/");
			}
			set.add(sb.toString());
		}
		return set.size();
	}
}
