package Nov2020_GoogPrep;

public class _002OddEvenJump {

	public static void main(String[] args) {
		System.out.println(oddEvenJumps(new int[] { 10, 13, 12, 14, 15 }));
		System.out.println(oddEvenJumps(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(oddEvenJumps(new int[] { 5, 1, 3, 4, 2 }));
	}

	public static int oddEvenJumps(int[] A) {
		if (A == null || A.length == 0)
			return 0;
	}
}
