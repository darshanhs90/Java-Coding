package Nov2020Leetcode;

public class _1184DistanceBetweenBusStops {
	public static void main(String[] args) {
		System.out.println(distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 1));
		System.out.println(distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 2));
		System.out.println(distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 3));
		System.out.println(distanceBetweenBusStops(new int[] { 7, 10, 1, 12, 11, 14, 5, 0 }, 7, 2));
	}

	public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int totalSum = 0;
		int forwardDistance = 0;
		int startIndex = Math.min(start, destination);
		int endIndex = Math.max(start, destination);
		boolean started = false;
		boolean ended = false;
		for (int i = 0; i < distance.length; i++) {
			if (i >= startIndex && i < endIndex) {
				forwardDistance += distance[i];
				started = true;
			} else if (started && i == endIndex && !ended) {
				ended = true;
			}
			totalSum += distance[i];
		}

		return Math.min(forwardDistance, totalSum - forwardDistance);
	}

}
