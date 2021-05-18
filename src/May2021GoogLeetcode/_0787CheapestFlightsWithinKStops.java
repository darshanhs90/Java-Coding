package May2021GoogLeetcode;

public class _0787CheapestFlightsWithinKStops {
	public static void main(String[] args) {
		System.out.println(findCheapestPrice(3,
				new int[][] { new int[] { 0, 1, 100 }, new int[] { 1, 2, 100 }, new int[] { 0, 2, 500 } }, 0, 2, 1));

		System.out.println(findCheapestPrice(3,
				new int[][] { new int[] { 0, 1, 200 }, new int[] { 1, 2, 100 }, new int[] { 0, 2, 500 } }, 0, 2, 0));
	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

	}
}
