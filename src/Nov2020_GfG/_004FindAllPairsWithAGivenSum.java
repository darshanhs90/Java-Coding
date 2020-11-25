package Nov2020_GfG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class _004FindAllPairsWithAGivenSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int len1 = sc.nextInt();
			int len2 = sc.nextInt();
			int sum = sc.nextInt();
			int arr1[] = new int[len1];
			int arr2[] = new int[len2];
			for (int j = 0; j < len1; j++) {
				arr1[j] = sc.nextInt();
			}
			for (int j = 0; j < len2; j++) {
				arr2[j] = sc.nextInt();
			}
			getPairs(arr1, arr2, sum);
		}
		sc.close();
	}

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void getPairs(int arr1[], int[] arr2, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		StringBuilder sb = new StringBuilder();
		List<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < arr2.length; i++) {
			if (set.contains(sum - arr2[i])) {
				list.add(new Pair(sum - arr2[i], arr2[i]));
			}
		}

		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.x - o2.x;
			}

		});
		for (int j = 0; j < list.size(); j++) {
			sb = sb.append(list.get(j).x + " " + list.get(j).y + ", ");
		}

		if (sb.length() > 0) {
			sb = sb.deleteCharAt(sb.length() - 1);
			sb = sb.deleteCharAt(sb.length() - 1);
		} else {
			sb = sb.append("-1");
		}
		System.out.println(sb.toString());
	}
}
