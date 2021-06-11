package June2021GoogLeetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0818RaceCar {
	public static void main(String[] args) {
		System.out.println(racecar(3));
		System.out.println(racecar(6));
	}

	public static int racecar(int target) {
		Queue<int[]> q = new LinkedList<int[]>();
		HashSet<String> visited = new HashSet<String>();
		q.offer(new int[] { 0, 1 });
		visited.add("0/1");
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int pos = arr[0];
				int speed = arr[1];
				if (pos == target)
					return count;

				String str1 = pos + speed + "/" + speed * 2;
				String str2 = pos + "/" + (speed > 0 ? -1 : 1);
				if (!visited.contains(str1)) {
					q.offer(new int[] { pos + speed, speed * 2 });
					visited.add(str1);
				}

				if (!visited.contains(str2)) {
					q.offer(new int[] { pos, speed > 0 ? -1 : 1 });
					visited.add(str2);
				}
			}
			count++;
		}
		return -1;
	}
}
