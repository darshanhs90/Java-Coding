package Dec2020Leetcode;

public class _1184DistanceBetweenBusStops {
	public static void main(String[] args) {
		System.out.println(distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 1));
		System.out.println(distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 2));
		System.out.println(distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 3));
		System.out.println(distanceBetweenBusStops(new int[] { 7, 10, 1, 12, 11, 14, 5, 0 }, 7, 2));
	}

	public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
		if (start == destination)
			return 0;
		int sum = 0;
		for (int i = 0; i < distance.length; i++) {
			sum += distance[i];
		}

		int source = Math.min(start, destination);
		int dest = Math.max(start, destination);

		int fwdDistance = 0;
		for (int i = source; i <= dest - 1; i++) {
			fwdDistance += distance[i];
		}
		int backwardDistance = sum - fwdDistance;
		return Math.min(fwdDistance, backwardDistance);
	}
}
