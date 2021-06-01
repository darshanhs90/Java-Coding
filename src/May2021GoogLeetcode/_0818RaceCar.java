package May2021GoogLeetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0818RaceCar {
	public static void main(String[] args) {
		System.out.println(racecar(3));
		System.out.println(racecar(6));
	}

	public static int racecar(int target) {
		if (target == 0)
			return 0;

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 1 });
		HashSet<String> visited = new HashSet<String>();
		visited.add("0/1");
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				if (arr[0] == target)
					return count;

				int currPos = arr[0];
				int currSpeed = arr[1];

				String str1 = currPos + currSpeed + "/" + currSpeed * 2;
				String str2 = currPos + "/" + (currSpeed > 0 ? -1 : 1);

				if (!visited.contains(str1)) {
					q.offer(new int[] { currPos + currSpeed, currSpeed * 2 });
					visited.add(str1);
				}

				if (!visited.contains(str2)) {
					q.offer(new int[] { currPos, currSpeed > 0 ? -1 : 1 });
					visited.add(str2);
				}
			}
			count++;
		}
		return 0;
	}
}
